package com.example.pfa.service;

import com.example.pfa.DTO.ReservationDTO;
import com.example.pfa.DTO.ReservationJoiningRequest;
import com.example.pfa.entity.Reservation;
import com.example.pfa.enums.RequestStatus;
import com.example.pfa.event.ReservationExpiredEvent;
import com.example.pfa.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final FieldService fieldService;
    private final PlatformUserService platformUserService;
    private final ApplicationEventPublisher applicationEventPublisher;

    public void requestFieldReservation(ReservationDTO dto) {
        log.info(dto.field());
        Reservation reservation = dto.toEntity(fieldService.getFieldByType(dto.field()), platformUserService.getCurrentUser());
        reservationRepository.save(reservation);
    }

    public void rejectReservationRequest(Long id) {
        reservationRepository.delete(getReservationById(id));
    }

    public void grantReservationRequest(Long id) {
        getReservationById(id).setStatus(RequestStatus.ACCEPTED);
    }

    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id).orElseThrow(() -> new RuntimeException("no such reservation with this id"));
    }

    public void joinReservationPlayers(ReservationJoiningRequest request) {
        Reservation reservationToJoin = getReservationById(request.reservationId());
        if (reservationToJoin.getPassword().equals(request.password())) {
            reservationToJoin.getPlayer().add(platformUserService.getCurrentUser());
            reservationRepository.save(reservationToJoin);
        } else throw new RuntimeException("incorrect reservation password");
    }

    @Scheduled(fixedRate = 60000)
    @Transactional
    public void alertExpiredSession() {
        List<Reservation> expiredReservations = reservationRepository.findExpiredReservations(Instant.now());
        expiredReservations.forEach(reservation -> {
            applicationEventPublisher.publishEvent(new ReservationExpiredEvent(this, reservation));
            reservationRepository.delete(reservation);
        });
    }



}

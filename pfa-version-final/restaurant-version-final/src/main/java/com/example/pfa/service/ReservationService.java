package com.example.pfa.service;

import com.example.pfa.DTO.ReservationDTO;
import com.example.pfa.entity.Reservation;
import com.example.pfa.enums.RequestStatus;
import com.example.pfa.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final FieldService fieldService;
    private final PlatformUserService platformUserService;

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

    public void joinReservationPlayers(Long userId, String password) {
        Reservation reservationToJoin = getReservationById(userId);
        if (reservationToJoin.getRequestOwner().getEmail().equals(password)) {
            reservationToJoin.getPlayer().add(platformUserService.getCurrentUser());
        } else throw new RuntimeException("incorrect reservation password");
    }

}

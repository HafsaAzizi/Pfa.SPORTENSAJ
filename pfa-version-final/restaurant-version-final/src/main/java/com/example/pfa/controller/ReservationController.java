package com.example.pfa.controller;

import com.example.pfa.DTO.ReservationDTO;
import com.example.pfa.DTO.ReservationJoiningRequest;
import com.example.pfa.service.ReservationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Validated
@RestController
@RequestMapping("/api/v1/pfa/reservation")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/accept/{id}")
    public ResponseEntity<String> grantReservationRequest(@PathVariable("id") Long id) {
        reservationService.grantReservationRequest(id);
        return ResponseEntity.ok("reservation of field play session accepted");
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/reject/{id}")
    public ResponseEntity<String> rejectReservationRequest(@PathVariable("id") Long id) {
        reservationService.rejectReservationRequest(id);
        return ResponseEntity.ok("reservation of field play session rejected");
    }

    @PostMapping("/create-request")
    public ResponseEntity<String> test(@RequestBody ReservationDTO request) {
        log.info(request.password());
        reservationService.requestFieldReservation(request);
        return ResponseEntity.ok("request for field reservation submitted");
    }

    @PutMapping("/join-reservation")
    public ResponseEntity<String> joinReservationParty(@RequestBody ReservationJoiningRequest request) {
        log.info("the password is: " +request.password());
        reservationService.joinReservationPlayers(request);
        return ResponseEntity.ok("joined reservation player party successfully");
    }



}

package com.example.pfa.controller;

import com.example.pfa.DTO.ReservationDTO;
import com.example.pfa.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/create-new-request")
    public ResponseEntity<String> createNewReservation(@RequestBody ReservationDTO request) {
        reservationService.requestFieldReservation(request);
        return ResponseEntity.ok("request for field reservation submitted");
    }

    @PutMapping("/join-reservation/{id}")
    public ResponseEntity<String> joinReservationParty(@PathVariable("id") Long id ,@RequestBody String password) {
        reservationService.joinReservationPlayers(id, password);
        return ResponseEntity.ok("joined reservation player party successfully");
    }

    @PostMapping("/test")
    public String test() {
        return "test test test test ";
    }
}

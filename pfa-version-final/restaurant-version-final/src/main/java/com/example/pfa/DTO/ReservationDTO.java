package com.example.pfa.DTO;

import com.example.pfa.entity.Field;
import com.example.pfa.entity.PlatformUser;
import com.example.pfa.entity.Reservation;
import com.example.pfa.enums.RequestStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;
import java.time.Duration;

/**
 * DTO for Reservation entity
 * @param id Unique identifier
 * @param reservationDate Start time of reservation
 * @param reservationEnd End time of reservation
 * @param duration Duration of the reservation
 * @param requestText Optional special requests
 * @param password Access password for the reservation
 * @param status Current status of the reservation
 * @param field the associated field
 */
public record ReservationDTO(
        Long id,
        @JsonFormat @NotNull Instant reservationDate,
        Instant reservationEnd,
        @NotNull Long duration,
        String requestOwner,
        @NotNull String requestText,
        @NotNull String password,
        String status,
        @NotNull String field
) {
    /**
     * Static factory method to create DTO from entity
     */
    public static ReservationDTO fromEntity(Reservation reservation) {
        return new ReservationDTO(
                reservation.getId(),
                reservation.getReservationDate(),
                reservation.getReservationEnd(),
                reservation.getDuration().toMinutes(),
                reservation.getRequestOwner().getEmail(),
                reservation.getRequestText(),
                reservation.getPassword(),
                reservation.getStatus().toString(),
                reservation.getField().toString()
        );
    }

    /**
     * Converts DTO back to entity (for create/update operations)
     */
    public Reservation toEntity(Field field, PlatformUser user) {
        Reservation reservation = new Reservation();
        reservation.setId(this.id());
        reservation.setReservationDate(this.reservationDate());
        reservation.setDuration(Duration.ofMinutes(this.duration()));
        reservation.setReservationEnd(reservation.getReservationDate().plus(reservation.getDuration()));
        reservation.setRequestOwner(user);
        reservation.setRequestText(this.requestText());
        reservation.setPassword(this.password());
        reservation.setStatus(RequestStatus.PENDING);
        reservation.setField(field);
        return reservation;
    }
}
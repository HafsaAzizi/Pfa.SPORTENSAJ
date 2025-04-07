package com.example.pfa.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ReservationJoiningRequest(
        @Email
        @NotBlank
        Long reservationId,

        @NotBlank
        String password
) {}

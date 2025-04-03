package com.example.pfa.service;

import com.example.pfa.DTO.GuestDTO;
import com.example.pfa.entity.Guest;
import com.example.pfa.repository.GuestRepository;
import com.example.pfa.security.SecurityConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GuestService {

    private final GuestRepository guestRepository;
    private final SecurityConfig config;
    private final AuthenticationManager authenticationManager;

    public void guestSignUp(GuestDTO dto) {
        Guest newGuest = dto.toEntity();
        newGuest.setPassword(config.passwordEncoder().encode(dto.password()));
        guestRepository.save(newGuest);
    }
}

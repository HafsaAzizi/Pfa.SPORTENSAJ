package com.example.pfa.controller;

import com.example.pfa.DTO.GuestDTO;
import com.example.pfa.service.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/api/v1/pfa/guest")
@RequiredArgsConstructor
public class GuestController {

    private final GuestService guestServiceService;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody GuestDTO request) {
        guestServiceService.guestSignUp(request);
        return ResponseEntity.ok("guest account created successfully");
    }
}
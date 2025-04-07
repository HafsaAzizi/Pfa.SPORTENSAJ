package com.example.pfa.controller;

import com.example.pfa.DTO.LoginRequest;
import com.example.pfa.service.PlatformUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/api/v1/pfa/login")
@RequiredArgsConstructor
public class UserLoginController {

    private final PlatformUserService userService;

    @PostMapping()
    public ResponseEntity<String> logIn(@RequestBody LoginRequest request) {
        return ResponseEntity.ok("token: "+ userService.userLogIn(request));
    }
}

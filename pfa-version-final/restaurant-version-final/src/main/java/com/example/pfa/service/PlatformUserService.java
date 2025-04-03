package com.example.pfa.service;

import com.example.pfa.DTO.LoginRequest;
import com.example.pfa.exceptions.IncorrectCredentialsException;
import com.example.pfa.security.CustomUserDetails;
import com.example.pfa.security.SecurityConfig;
import com.example.pfa.security.jwt.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlatformUserService {

    private final SecurityConfig config;
    private final AuthenticationManager authenticationManager;

    public String userLogIn(LoginRequest loginRequest, HttpServletRequest servletRequest) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password());
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(token);
        } catch (BadCredentialsException e) {
            throw new IncorrectCredentialsException();
        }

        if (authentication.getPrincipal() instanceof CustomUserDetails customUser) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
            HttpSession session = servletRequest.getSession();
            session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());
            return JwtUtil.generateToken(customUser);
        } else {
            throw new IncorrectCredentialsException();
        }
    }
}

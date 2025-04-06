package com.example.pfa.service;

import com.example.pfa.DTO.LoginRequest;
import com.example.pfa.entity.PlatformUser;
import com.example.pfa.exceptions.IncorrectCredentialsException;
import com.example.pfa.exceptions.UserNotFoundException;
import com.example.pfa.repository.PlatformUserRepository;
import com.example.pfa.security.CustomUserDetails;
import com.example.pfa.security.SecurityConfig;
import com.example.pfa.security.jwt.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlatformUserService {

    private final AuthenticationManager authenticationManager;
    private final PlatformUserRepository<PlatformUser> platformUserRepository;

    public String userLogIn(LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password());
        Authentication authentication;

        try {
            authentication = authenticationManager.authenticate(token);
        } catch (BadCredentialsException e) {
            throw new IncorrectCredentialsException();
        }

        if (authentication.getPrincipal() instanceof CustomUserDetails customUser) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
            log.info("is user authenticated: "+ SecurityContextHolder.getContext().getAuthentication().isAuthenticated());
            log.info("authorities"+ customUser.getAuthorities().toString());
            return JwtUtil.generateToken(customUser);
        } else {
            throw new IncorrectCredentialsException();
        }
    }

    public PlatformUser getUserById(Long id) {
        return platformUserRepository
                .findById(id)
                .orElseThrow(
                        () -> new UserNotFoundException("no user with this id"+ id.toString())
        );
    }

    public PlatformUser getUserByEmail(String email) {
        return platformUserRepository
                .findByEmail(email)
                .orElseThrow(
                        () -> new UserNotFoundException("no user with this id"+ email)
        );
    }

    public PlatformUser getCurrentUser() {
        return getUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}

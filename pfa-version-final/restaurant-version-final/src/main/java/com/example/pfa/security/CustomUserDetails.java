package com.example.pfa.security;

import com.example.pfa.entity.Guest;
import com.example.pfa.entity.PlatformUser;
import com.example.pfa.entity.Student;
import com.example.pfa.entity.Teacher;
import com.example.pfa.enums.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Slf4j
public record CustomUserDetails(PlatformUser user) implements UserDetails {

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        try {
            if (((Teacher) user).isAdmin()) authorities.add(new SimpleGrantedAuthority("ROLE_"+ Role.ADMIN));
        } catch (ClassCastException e) {
            log.info("this user isn't a teacher");
        } finally {
            authorities.add(new SimpleGrantedAuthority("ROLE_"+ user.getRole()));
        }

        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
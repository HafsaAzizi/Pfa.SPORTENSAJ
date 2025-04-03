package com.example.pfa.security;

import com.example.pfa.entity.Guest;
import com.example.pfa.entity.PlatformUser;
import com.example.pfa.entity.Student;
import com.example.pfa.entity.Teacher;
import com.example.pfa.exceptions.UserNotFoundException;
import com.example.pfa.repository.StudentRepository;
import com.example.pfa.repository.PlatformUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final PlatformUserRepository<PlatformUser> userRepository;
    private final StudentRepository studentRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .map(user -> switch (user) {
                    case Student student -> new CustomUserDetails(student);
                    case Teacher teacher -> new CustomUserDetails(teacher);
                    case Guest guest -> new CustomUserDetails(guest);
                    default -> throw new IllegalStateException();
                })
                .orElseThrow(() -> new UserNotFoundException("There is no user available with this email: "+username));
    }
}

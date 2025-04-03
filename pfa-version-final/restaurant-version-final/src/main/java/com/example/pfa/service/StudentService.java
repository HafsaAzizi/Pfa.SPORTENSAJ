package com.example.pfa.service;

import com.example.pfa.DTO.StudentDTO;
import com.example.pfa.entity.Student;
import com.example.pfa.repository.StudentRepository;
import com.example.pfa.security.SecurityConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {

    private final StudentRepository studentRepository;
    private final SecurityConfig config;
    private final AuthenticationManager authenticationManager;

    public void studentSignUp(StudentDTO dto) {
        Student newStudent = dto.toEntity();
        newStudent.setPassword(config.passwordEncoder().encode(dto.password()));
        studentRepository.save(newStudent);
    }

    public List<StudentDTO> getAllStudents() {
        return studentRepository
                .findAll()
                .stream()
                .map(StudentDTO::fromEntity)
                .toList();
    }

}
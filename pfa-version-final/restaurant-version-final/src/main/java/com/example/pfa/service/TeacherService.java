package com.example.pfa.service;

import com.example.pfa.entity.Teacher;
import com.example.pfa.enums.Department;
import com.example.pfa.enums.Gender;
import com.example.pfa.enums.Role;
import com.example.pfa.repository.TeacherRepository;
import com.example.pfa.security.SecurityConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final SecurityConfig config;

}

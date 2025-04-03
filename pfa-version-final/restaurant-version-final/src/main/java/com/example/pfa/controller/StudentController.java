package com.example.pfa.controller;

import com.example.pfa.DTO.StudentDTO;
import com.example.pfa.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v1/pfa/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody StudentDTO request) {
        studentService.studentSignUp(request);
        return ResponseEntity.ok("student account created successfully");
    }

    @GetMapping("/all-students")
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }
}

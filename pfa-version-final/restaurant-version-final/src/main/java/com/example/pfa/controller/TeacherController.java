package com.example.pfa.controller;

import com.example.pfa.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/api/v1/pfa/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

}

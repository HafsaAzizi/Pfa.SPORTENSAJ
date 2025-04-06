package com.example.pfa.config;

import com.example.pfa.entity.Field;
import com.example.pfa.entity.Teacher;
import com.example.pfa.enums.Department;
import com.example.pfa.enums.FieldType;
import com.example.pfa.enums.Gender;
import com.example.pfa.enums.Role;
import com.example.pfa.repository.FieldRepository;
import com.example.pfa.repository.TeacherRepository;
import com.example.pfa.security.SecurityConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Slf4j
@Configuration
public class ApplicationConfig {

    @Bean
    CommandLineRunner initDataBase(FieldRepository fieldRepository, TeacherRepository teacherRepository, SecurityConfig config) {
        return args -> {
            Arrays.stream(FieldType.values())
                    .filter(fieldType1 -> !fieldRepository.existsByFieldType(fieldType1))
                    .forEach(fieldType ->
                            fieldRepository.save(new Field(null, fieldType, true))
                    );
        };
    }
}

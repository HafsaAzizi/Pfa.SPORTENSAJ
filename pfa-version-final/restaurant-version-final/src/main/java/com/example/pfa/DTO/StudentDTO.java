package com.example.pfa.DTO;

import com.example.pfa.entity.Student;
import com.example.pfa.enums.Department;
import com.example.pfa.enums.Gender;
import com.example.pfa.enums.Major;
import com.example.pfa.enums.Role;
import jakarta.validation.constraints.NotNull;

public record StudentDTO(
        @NotNull String cin,
        @NotNull String email,
        @NotNull String password,
        @NotNull String firstName,
        @NotNull String lastName,
        @NotNull Long age,
        @NotNull Gender gender,
        @NotNull String cne,
        @NotNull String major,
        @NotNull String department

) {

    // Conversion method
    public static StudentDTO fromEntity(Student student) {
        return new StudentDTO(
                student.getCin(),
                student.getEmail(),
                "*********",
                student.getFirstName(),
                student.getLastName(),
                student.getAge(),
                student.getGender(),
                student.getCne(),
                student.getMajor().getCode(),
                student.getDepartment().getCode()
        );
    }

    public Student toEntity() {
        Student student = new Student();
        student.setCin(this.cin());
        student.setEmail(this.email());
        student.setFirstName(this.firstName());
        student.setLastName(this.lastName());
        student.setAge(this.age);
        student.setGender(this.gender());
        student.setCne(this.cne());
        student.setMajor(Major.fromCode(this.major));
        student.setDepartment(Department.fromCode(this.department));
        student.setRole(Role.STUDENT);
        return student;
    }
}
package com.example.pfa.DTO;

import com.example.pfa.entity.Teacher;
import com.example.pfa.enums.Department;
import com.example.pfa.enums.Gender;
import com.example.pfa.enums.Role;
import jakarta.validation.constraints.NotNull;

public record TeacherDTO (
        String cin,
        String email,
        String password,
        String firstName,
        String lastName,
        Long age,
        Gender gender,
        @NotNull String teacherID,
        @NotNull String department
) {

    // Conversion method
    public static TeacherDTO fromEntity(Teacher teacher) {
        return new TeacherDTO(
                teacher.getCin(),
                teacher.getEmail(),
                teacher.getPassword(),
                teacher.getFirstName(),
                teacher.getLastName(),
                teacher.getAge(),
                teacher.getGender(),
                teacher.getTeacherID(),
                teacher.getDepartment().getCode()
        );
    }

    public Teacher toEntity() {
        Teacher teacher = new Teacher();
        teacher.setCin(this.cin());
        teacher.setEmail(this.email());
        teacher.setFirstName(this.firstName());
        teacher.setLastName(this.lastName());
        teacher.setAge(this.age);
        teacher.setGender(this.gender());
        teacher.setTeacherID(this.teacherID);
        teacher.setDepartment(Department.fromCode(this.department));
        teacher.setRole(Role.TEACHER);
        return teacher;
    }
}

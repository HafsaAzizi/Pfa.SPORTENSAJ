package com.example.pfa.entity;

import com.example.pfa.enums.Department;
import com.example.pfa.enums.Gender;
import com.example.pfa.enums.Role;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("TEACHER")
public class Teacher extends PlatformUser {

    @Column(length = 100, nullable = true, unique = true)
    private String teacherID;

    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private Department department;


    public Teacher() {}

    public Teacher(String teacherID, Department department) {
        this.teacherID = teacherID;
        this.department = department;
    }

    public Teacher(Long id, String cin, String email, String password, String firstName, String lastName, Long age, Role role, Gender gender, String teacherID, Department department) {
        super(id, cin, email, password, firstName, lastName, age, role, gender);
        this.teacherID = teacherID;
        this.department = department;
    }


    public String getTeacherID() {
        return this.teacherID;
    }

    public Department getDepartment() {
        return this.department;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}

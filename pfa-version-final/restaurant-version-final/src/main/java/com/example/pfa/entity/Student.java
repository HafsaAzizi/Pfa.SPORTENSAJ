package com.example.pfa.entity;

import com.example.pfa.enums.Department;
import com.example.pfa.enums.Gender;
import com.example.pfa.enums.Major;
import com.example.pfa.enums.Role;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("STUDENT")
public class Student extends PlatformUser {

    @Column(length = 100, nullable = true, unique = true)
    private String cne;

    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private Major major;

    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private Department department;

    public Student() {}

    public Student(String cne, Major major, Department department) {
        this.cne = cne;
        this.major = major;
        this.department = department;
    }

    public Student(Long id, String cin, String email, String password, String firstName, String lastName, Long age, Role role, Gender gender, String cne, Major major, Department department) {
        super(id, cin, email, password, firstName, lastName, age, role, gender);
        this.cne = cne;
        this.major = major;
        this.department = department;
    }


    public String getCne() {
        return this.cne;
    }

    public Major getMajor() {
        return this.major;
    }

    public Department getDepartment() {
        return this.department;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}

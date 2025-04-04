package com.example.pfa.entity;

import com.example.pfa.enums.Gender;
import com.example.pfa.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("GUEST")
public class Guest extends PlatformUser {

    @Column(length = 100, nullable = true, unique = true)
    private String cne;

    @Column(nullable = true)
    private String university;


    public Guest() {}

    public Guest(String cne, String university) {
        this.cne = cne;
        this.university = university;
    }

    public Guest(Long id, String cin, String email, String password, String firstName, String lastName, Long age, Role role, Gender gender, String cne, String university) {
        super(id, cin, email, password, firstName, lastName, age, role, gender);
        this.cne = cne;
        this.university = university;
    }


    public String getCne() {
        return this.cne;
    }

    public String getUniversity() {
        return this.university;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

}

package com.example.pfa.entity;

import com.example.pfa.enums.Gender;
import com.example.pfa.enums.Role;
import jakarta.persistence.*;

@Entity
@Table(name = "app_user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role", discriminatorType = DiscriminatorType.STRING)
public abstract class PlatformUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String cin;

    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @Column(length = 200, nullable = false)
    private String password;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Long age;

    @Column(name = "role", insertable = false, updatable = false, nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "gender", length = 50, nullable = false)
    private Gender gender;


    public PlatformUser() {}

    public PlatformUser(Long id, String cin, String email, String password, String firstName, String lastName, Long age, Role role, Gender gender) {
        this.id = id;
        this.cin = cin;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.role = role;
        this.gender = gender;
    }


    public Long getId() {
        return this.id;
    }

    public String getCin() {
        return this.cin;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Long getAge() {
        return this.age;
    }

    public Role getRole() {
        return this.role;
    }

    public Gender getGender() {
        return this.gender;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}

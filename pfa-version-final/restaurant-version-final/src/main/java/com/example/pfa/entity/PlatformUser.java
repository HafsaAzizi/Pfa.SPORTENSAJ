package com.example.pfa.entity;

import com.example.pfa.enums.Gender;
import com.example.pfa.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
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

    @Column(name = "role", insertable = false, updatable = false ,nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role = Role.STUDENT;

    @Column(name = "gender", length = 50, nullable = false)
    private Gender gender;


}

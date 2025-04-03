package com.example.pfa.entity;

import com.example.pfa.enums.Department;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@DiscriminatorValue("TEACHER")
public class Teacher extends PlatformUser {

    @Column(length = 100, nullable = true, unique = true)
    private String teacherID;

    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private Department department;


}

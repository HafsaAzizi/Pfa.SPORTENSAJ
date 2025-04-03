package com.example.pfa.entity;

import com.example.pfa.enums.Department;
import com.example.pfa.enums.Major;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
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

}

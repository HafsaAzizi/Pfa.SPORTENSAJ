package com.example.pfa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@DiscriminatorValue("GUEST")
    public class Guest extends PlatformUser {

    @Column(length = 100, nullable = true, unique = true)
    private String cne;

    @Column(nullable = true)
    private String university;
}

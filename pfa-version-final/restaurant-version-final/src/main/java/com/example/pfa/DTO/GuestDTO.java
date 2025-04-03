package com.example.pfa.DTO;

import com.example.pfa.entity.Guest;
import com.example.pfa.entity.Student;
import com.example.pfa.entity.Teacher;
import com.example.pfa.enums.Gender;
import com.example.pfa.enums.Major;
import com.example.pfa.enums.Role;
import jakarta.validation.constraints.NotNull;

public record GuestDTO(
        @NotNull String cin,
        @NotNull String email,
        @NotNull String password,
        @NotNull String firstName,
        @NotNull String lastName,
        @NotNull Long age,
        @NotNull Gender gender,
        @NotNull String cne,
        @NotNull String university
) {

    // Conversion method
    public static GuestDTO fromEntity(Guest guest) {
        return new GuestDTO(
                guest.getCin(),
                guest.getEmail(),
                guest.getPassword(),
                guest.getFirstName(),
                guest.getLastName(),
                guest.getAge(),
                guest.getGender(),
                guest.getCne(),
                guest.getUniversity()
        );
    }

    public Guest toEntity() {
        Guest guest = new Guest();
        guest.setCin(this.cin());
        guest.setEmail(this.email());
        guest.setFirstName(this.firstName());
        guest.setLastName(this.lastName());
        guest.setAge(this.age);
        guest.setGender(this.gender());
        guest.setCne(this.cne());
        guest.setUniversity(this.university);
        guest.setRole(Role.GUESS);
        return guest;
    }
}

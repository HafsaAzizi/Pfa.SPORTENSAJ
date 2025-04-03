package com.example.pfa.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.List;

public enum Department {
    TRI("TRI", "Télécommunications, Réseaux et Informatique"),
    STIN("STIN", "SCIENCES ET TECHNOLOGIES INDUSTRIELLES"),
    CP("CP", "cycle préparatoire");

    private final String code;
    private final String fullName;

    Department(String code, String fullName) {
        this.code = code;
        this.fullName = fullName;
    }


    @JsonValue
    public String getCode() {
        return code;
    }


    public String getFullName() {
        return fullName;
    }

    /**
     * Converts from department code to enum value
     * @throws IllegalArgumentException if code is invalid
     */
    @JsonCreator
    public static Department fromCode(String code) {
        for (Department department : values()) {
            if (department.code.equals(code)) {
                return department;
            }
        }
        throw new IllegalArgumentException("Invalid major code: " + code);
    }

    /**
     * Provides all department for UI dropdowns
     */
    public static List<Department> getAllMajors() {
        return List.of(values());
    }

    /**
     * Checks if a code represents a valid department
     */
    public static boolean isValidDepartments(String code) {
        try {
            fromCode(code);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
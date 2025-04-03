package com.example.pfa.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.List;

public enum Major {
    IITE("IITE", "Ingénierie Informatique et Technologies Emergentes"),
    GEE("GEE", "Génie Energétique et Electrique"),
    ISIC("ISIC", "Ingénierie des Systèmes d’Information et de Communication"),
    GC("GC", "Génie Civil "),
    CCN("CCN", "cybersécurité et confiance numérique"),
    GI("GI", "Génie Industriel"),
    SDIA("SDIA", "science des données et intelligence artificielle"),
    CP("CP", "cycle préparatoire");

    private final String code;
    private final String fullName;

    Major(String code, String fullName) {
        this.code = code;
        this.fullName = fullName;
    }

    /**
     * Returns the short department code (e.g. "IITE")
     */
    @JsonValue
    public String getCode() {
        return code;
    }

    /**
     * Returns the full official major name
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Converts from department code to enum value
     * @throws IllegalArgumentException if code is invalid
     */
    @JsonCreator
    public static Major fromCode(String code) {
        for (Major major : values()) {
            if (major.code.equals(code)) {
                return major;
            }
        }
        throw new IllegalArgumentException("Invalid major code: " + code);
    }

    /**
     * Provides all majors for UI dropdowns
     */
    public static List<Major> getAllMajors() {
        return List.of(values());
    }

    /**
     * Checks if a code represents a valid major
     */
    public static boolean isValidMajor(String code) {
        try {
            fromCode(code);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}

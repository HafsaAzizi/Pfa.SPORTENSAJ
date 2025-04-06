package com.example.pfa.entity;

import com.example.pfa.enums.FieldType;
import jakarta.persistence.*;

@Entity
@Table(name = "field")
public class Field {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "field_type", length = 50, nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private FieldType fieldType;

    @Column(name = "availability")
    private boolean availability;


    public Field() {}

    public Field(Long id, FieldType fieldType, boolean availability) {
        this.id = id;
        this.fieldType = fieldType;
        this.availability = availability;
    }


    public Long getId() {
        return this.id;
    }

    public FieldType getFieldType() {
        return this.fieldType;
    }

    public boolean isAvailability() {
        return this.availability;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFieldType(FieldType fieldType) {
        this.fieldType = fieldType;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}

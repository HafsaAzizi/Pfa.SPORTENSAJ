package com.example.pfa.service;

import com.example.pfa.DTO.ReservationDTO;
import com.example.pfa.entity.Field;
import com.example.pfa.entity.Reservation;
import com.example.pfa.enums.FieldType;
import com.example.pfa.enums.RequestStatus;
import com.example.pfa.exceptions.FieldUnAvailableException;
import com.example.pfa.repository.FieldRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@RequiredArgsConstructor
@Slf4j
public class FieldService {

    private final FieldRepository fieldRepository;


    public Field getFieldByType(String type) {
        Field field = fieldRepository
                .findFieldByFieldType(FieldType.valueOf(type))
                .orElseThrow(
                        () -> new FieldUnAvailableException("this field is unavailable")
                );
        if (field.isAvailability()) return field;
        else throw new FieldUnAvailableException("this field is unavailable");
    }
}

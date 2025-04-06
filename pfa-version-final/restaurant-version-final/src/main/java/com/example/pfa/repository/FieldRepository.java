package com.example.pfa.repository;

import com.example.pfa.entity.Field;
import com.example.pfa.enums.FieldType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FieldRepository extends JpaRepository<Field, Long> {

    boolean existsByFieldType(FieldType fieldType);

    Optional<Field> findFieldByFieldType(FieldType fieldType);
}

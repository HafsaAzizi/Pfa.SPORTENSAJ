package com.example.pfa.repository;

import com.example.pfa.entity.Teacher;
import com.example.pfa.enums.Department;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository extends PlatformUserRepository<Teacher> {

    Optional<Teacher> findTeacherByTeacherID(String id);

    List<Teacher> findTeacherByDepartment(Department department);
}

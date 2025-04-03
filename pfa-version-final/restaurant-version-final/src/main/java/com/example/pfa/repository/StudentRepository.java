package com.example.pfa.repository;

import com.example.pfa.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends PlatformUserRepository<Student> {

    List<Student> findStudentByMajor(String major);
}

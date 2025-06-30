package com.example.spring_project.grade.repository;

import com.example.spring_project.grade.domain.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface SpringDataJpaGradeRepository extends JpaRepository<Grade, Long> {
    // Optional<Grade> findByName(String name);
    Optional<Grade> findByStudentNumber(String name);
    Optional<Grade> findById(Long id);
    Optional<Grade> findByName(String name);
}

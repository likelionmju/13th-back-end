package com.example.grade.repository;

import com.example.grade.entity.GradeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GradeRepository extends JpaRepository<GradeEntity, Long> {

    GradeEntity findByName(String name);

    List<GradeEntity> findTop3ByOrderByScoreDesc();

    GradeEntity findByStudentNumber(String studentNumber);
}

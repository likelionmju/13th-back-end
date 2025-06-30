package com.example.demo.Repository;

import com.example.demo.Model.StudentScore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ScoreRepository extends JpaRepository<StudentScore, Long> {
        Optional<StudentScore> findByName(String name);
        List<StudentScore> findTop3ByOrderByScore();
}

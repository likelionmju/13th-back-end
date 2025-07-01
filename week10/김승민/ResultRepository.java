package com.example.week10;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ResultRepository extends JpaRepository<Result, Long> {
    Optional<Result> findByName(String name);
    List<Result> findTop3ByOrderByScoreDesc();
}

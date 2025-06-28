package com.example.week10_hw.repository;

import com.example.week10_hw.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    public List<Student> findByName(String name);
    public List<Student> findTop3ByOrderByScoreDesc();

}

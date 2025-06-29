package com.example.grade.service;

import com.example.grade.entity.GradeEntity;
import com.example.grade.repository.GradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GradeService {
    private final GradeRepository gradeRepository;


    public List<GradeEntity> findAll() {
        return gradeRepository.findAll();
    }

    public List<GradeEntity> findTop3ByScore() {
        return gradeRepository.findTop3ByOrderByScoreDesc();
    }

    public GradeEntity save(GradeEntity gradeEntity) {
        return gradeRepository.save(gradeEntity);
    }

    public GradeEntity findByStudentNumber(String studentNumber) {
        return gradeRepository.findByStudentNumber(studentNumber);
    }

    public GradeEntity findByName(String name) {
        return gradeRepository.findByName(name);
    }


    public void delete(Long id) {
        gradeRepository.deleteById(id);
    }

    public GradeEntity update(String name, int score) {
        GradeEntity gradeEntity = gradeRepository.findByName(name);
        gradeEntity.setScore(score);
        return gradeRepository.save(gradeEntity);
    }
}

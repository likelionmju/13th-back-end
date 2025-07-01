package com.example.spring_project.grade.service;

import com.example.spring_project.grade.repository.SpringDataJpaGradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.spring_project.grade.domain.Grade;

import javax.swing.text.html.Option;
import java.util.*;

@Service
public class GradeService {
    private final SpringDataJpaGradeRepository gradeRepository;

    @Autowired
    public GradeService(SpringDataJpaGradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    // 성적 등록(수정 upddate로 별도)
    public Grade save(Grade grade) {
        return gradeRepository.save(grade);
    }

    public Grade findById(Long id) {
        return gradeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 성적이 없습니다: " + id));
    }

    public List<Grade> findAll() {
        return gradeRepository.findAll();
    }

    public Optional<Grade> findByStudentNumber(String studentNumber) {
        return gradeRepository.findByStudentNumber(studentNumber);
    }


    public void deleteById(Long id) {
        gradeRepository.deleteById(id);
    }

    // 수정
    public Grade update(Long id, Grade request) {
        Grade grade = gradeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 성적이 없습니다: " + id));

        grade.setName(request.getName());
        grade.setStudentNumber(request.getStudentNumber());
        grade.setScore(request.getScore());

        return gradeRepository.save(grade);
    }

    public Grade findByName(String name) {
        return gradeRepository.findByName(name).orElse(new Grade());
    }

}

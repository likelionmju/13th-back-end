package com.example.spring_gradeservice.service;

import com.example.spring_gradeservice.domain.Grade;
import com.example.spring_gradeservice.repository.GradeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor

public class GradeService {

        private final GradeRepository gradeRepository;

        // 등록
        public Grade save(Grade grade) {
            return gradeRepository.save(grade);
        }

        // 전체 조회

        public List<Grade> findAll() {
            return gradeRepository.findAll();
        }

        // 이름으로 조회
        public List<Grade> findByName(String name) {
            return gradeRepository.findByName(name);
        }

        // 학번으로 조회
        public Grade findByStudentId(String studentId) {
            return gradeRepository.findByStudentId(studentId);
        }

        // 점수 상위 3명
        public List<Grade> findTop3() {
            return gradeRepository.findTop3ByOrderByGradeDesc();
        }

        // 점수 수정
        public Grade updateGrade(Long id, int newGrade) {
            Grade grade = gradeRepository.findById(id).orElseThrow();
            grade.setGrade(newGrade);
            return gradeRepository.save(grade);
        }

        // 삭제
        public void delete(Long id) {
            gradeRepository.deleteById(id);
        }
    }


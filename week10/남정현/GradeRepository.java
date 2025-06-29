package com.example.spring_gradeservice.repository;

import com.example.spring_gradeservice.domain.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, Long> {
    Grade findByStudentId(String studentId);
    List<Grade> findByName(String name);
    List<Grade> findTop3ByOrderByGradeDesc();


//    - 등록: 이름, 학번, 점수
//- 조회: 학생별 성적 조회(학생 id로, 이름으로 각각 ), 전체 조회, 점수 높은 순으로 3명 조회
//- 수정: 점수 수정
//- 삭제: 성적 삭제
}

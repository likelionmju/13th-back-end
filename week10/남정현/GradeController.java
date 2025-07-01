package com.example.spring_gradeservice.controller;


import com.example.spring_gradeservice.domain.Grade;
import com.example.spring_gradeservice.service.GradeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/grades")
@Tag(name="GradeAPI", description = "성적 관리 API")
public class GradeController {


    private final GradeService gradeService;

    // 등록
    @PostMapping
    @Operation(summary = "학생성적 추가", description = "name, grade, studentId로 추가")
    public Grade create(@RequestBody Grade grade) {
        return gradeService.save(grade);
    }

    // 전체 조회
    @GetMapping
    @Operation(summary = "전체 성적 조회", description = "등록된 모든 학생의 성적 정보 조회")

    public List<Grade> getAll() {
        return gradeService.findAll();
    }

    // 이름으로 조회
    @GetMapping("/name")
    @Operation(summary = "이름으로 성적 조회", description = "학생 이름(name)으로 성적 정보 조회")
    public List<Grade> getByName(@RequestParam String name) {
        return gradeService.findByName(name);
    }

    // 학번으로 조회
    @GetMapping("/student")
    @Operation(summary = "학번으로 성적 조회", description = "학생 학번(studentId)으로 성적 정보 조회")

    public Grade getByStudentId(@RequestParam String studentId) {
        return gradeService.findByStudentId(studentId);
    }

    // 상위 3명 조회
    @GetMapping("/top3")
    @Operation(summary = "점수 상위 3명 조회", description = "grade를 기준으로 상위 3명의 학생 성적 조회")

    public List<Grade> getTop3() {
        return gradeService.findTop3();
    }

    // 점수 수정
    @PutMapping("/{id}")
    @Operation(summary = "성적 수정", description = "학생 ID를 기준으로 성적 수정")

    public Grade update(@PathVariable Long id, @RequestParam int grade) {
        return gradeService.updateGrade(id, grade);
    }

    // 삭제
    @DeleteMapping("/{id}")
    @Operation(summary = "성적 삭제", description = "학생 ID를 기준으로 성적 정보 삭제")

    public void delete(@PathVariable Long id) {
        gradeService.delete(id);
    }



}

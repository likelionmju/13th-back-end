package com.example.grade.controller;

import com.example.grade.entity.GradeEntity;
import com.example.grade.service.GradeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/grade")
@RequiredArgsConstructor
@Tag(name = "GradeAPI", description = "학생 성적 관리 API")
public class GradeController {
    private final GradeService gradeService;

    @PostMapping("/create")
    @Operation(summary = "학생 성적 추가", description = "name, studentNumber, score로 추가")
    public GradeEntity create(@RequestBody GradeEntity gradeEntity) {
        return gradeService.save(gradeEntity);
    }

    @GetMapping("/all")
    @Operation(summary = "학생 전체 조회")
    public List<GradeEntity> findAll() {
        return gradeService.findAll();
    }

    @GetMapping("/top3")
    @Operation(summary = "학생 점수 높은 순으로 3명 조회")
    public List<GradeEntity> findTop3ByScore() {
        return gradeService.findTop3ByScore();
    }

    @GetMapping("/id/{studentNumber}")
    @Operation(summary = "학생 id로 조회")
    public GradeEntity findByStudentNumber(@PathVariable String studentNumber) {
        return gradeService.findByStudentNumber(studentNumber);
    }

    @GetMapping("/name/{name}")
    @Operation(summary = "학생 이름으로 조회")
    public GradeEntity findByName(@PathVariable String name) {
        return gradeService.findByName(name);
    }


    @PutMapping
    @Operation(summary = "학생 점수 수정")
    public GradeEntity update(@RequestBody GradeEntity gradeEntity) {
        return gradeService.update(gradeEntity.getName(), gradeEntity.getScore());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "성적 삭제")
    public void delete(@PathVariable Long id) {
        gradeService.delete(id);
    }

}

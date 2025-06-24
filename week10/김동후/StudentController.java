package com.example.week10assignment;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
@Tag(name = "StudentAPI", description = "학생 성적 관리 API")
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/create")
    @Operation(summary = "학생 등록", description = "이름, 학번, 점수를 받아 학생을 등록합니다.")
    public Student create(@RequestBody Student student) {
        return studentService.save(student);
    }

    @GetMapping("/all")
    @Operation(summary = "전체 조회", description = "등록된 전체 학생을 조회합니다.")
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/id/{id}")
    @Operation(summary = "ID로 조회", description = "학생의 고유 ID로 성적을 조회합니다.")
    public Student findById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @GetMapping("/name/{name}")
    @Operation(summary = "이름으로 조회", description = "학생 이름으로 성적을 조회합니다.")
    public Student findByName(@PathVariable String name) {
        return studentService.findByName(name);
    }

    @GetMapping("/top3")
    @Operation(summary = "Top3 성적 조회", description = "점수 기준으로 상위 3명의 학생을 조회합니다.")
    public List<Student> findTop3() {
        return studentService.findTop3();
    }

    @PutMapping("/update")
    @Operation(summary = "점수 수정", description = "학생 ID와 새로운 점수로 수정")
    public Student updateScore(@RequestBody ScoreUpdateRequest request) {
        return studentService.updateScore(request.getId(), request.getScore());
    }



    @DeleteMapping("/{id}")
    @Operation(summary = "학생 삭제", description = "해당 ID 학생 정보를 완전히 삭제합니다.")
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }
}

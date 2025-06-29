package example.grade.controller;

import example.grade.domain.Student;
import example.grade.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
@Tag(name = "GradeAPI", description = "학생 성적 관리 API")
public class StudentController {
    @Autowired
    private StudentService service;

    @PostMapping
    @Operation(summary = "학생 성적 추가", description = "name, studentNumber, score로 추가")
    public Student register(@RequestBody Student student) {
        return service.save(student);
    }

    @GetMapping
    @Operation(summary = "학생 전체 조회")
    public List<Student> allStudents() {
        return service.findAll();
    }

    @GetMapping("/id/{studentId}")
    @Operation(summary = "학생 id로 조회")
    public Optional<Student> findByStudentNumber(@PathVariable String studentNumber) {
        return service.findByStudentNumber(studentNumber);
    }

    @GetMapping("/name/{name}")
    @Operation(summary = "학생 이름으로 조회")
    public List<Student> findByName(@PathVariable String name) {
        return service.findByName(name);
    }

    @GetMapping("/top3")
    @Operation(summary = "학생 점수 높은 순으로 3명 조회")
    public List<Student> top3Students() {
        return service.findTop3ByScore();
    }

    @PutMapping("/{id}")
    @Operation(summary = "학생 점수 수정")
    public Optional<Student> updateScore(@PathVariable Long id, @RequestParam int score) {
        return service.updateScore(id, score);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "성적 삭제")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

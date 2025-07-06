package com.example.week10_hw.controller;

import com.example.week10_hw.domain.Student;
import com.example.week10_hw.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
@Tag(name = "ContactAPI", description = "학생 등록 API")
public class StudentController {
    private final StudentService studentService;
    //등록
    @PostMapping("/register")
    @Operation(summary = "학생객체 등록", description = "name,stdId,score로 추가")
    public Student register(@RequestBody Student student){
        return studentService.save(student);
    }

    //조회

    //id로 조회
    @GetMapping("/id/{id}")
    @Operation(summary = "id로 찾기", description = "id로 학생 객체 찾기")
    public Optional<Student> findById(@PathVariable Long id){
        return studentService.findById(id);
    }

    //이름으로 조회
    @GetMapping("/name/{name}")
    @Operation(summary = "이름으로 찾기", description = "이름으로 학생 리스트 찾기")
    public List<Student> findByName(@PathVariable String name){
        return studentService.findByName(name);
    }
    //전체조회
    @GetMapping("/all")
    @Operation(summary = "전체 조회", description = "전체 학생리스트 반환")
    public List<Student> findAll(){
        return studentService.findAll();
    }
    //점수 높은 순으로 3명 조회
    @GetMapping("/top3")
    @Operation(summary = "점수 높은 3명 반환", description = "점수 높은 순으로 학생 객체 3개 반환")
    public List<Student> getTop3(){
        return studentService.getTop3();
    }
    //수정
    //점수 수정
    @PutMapping
    @Operation(summary = "수정", description = "점수 수정")
    public Student update(@RequestBody Student student){
        return studentService.update(student);
    }

    //삭제
    //성적 삭제
    @DeleteMapping("/{id}")
    @Operation(summary = "삭제", description = "id 입력 -> 학생 객체 삭제")
    public void delete(@PathVariable Long id){
        studentService.delete(id);
    }
}

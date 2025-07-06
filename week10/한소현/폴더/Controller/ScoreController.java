package com.example.demo.Controller;

import com.example.demo.Model.StudentScore;
import com.example.demo.Service.ScoreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/StudentScore")
@RequiredArgsConstructor
@Tag(name = "StudentScoreAPI", description = "학생 성적 관리 API")
public class ScoreController {
    private final ScoreService service;

    @PostMapping("/crete")
    @Operation(summary = "성적 추가", description = "name, studentId, score로 추가")
    public StudentScore crete(@RequestBody StudentScore studentScore){
        return service.save(studentScore);
    }

    @GetMapping("/all")
    @Operation(summary = "모든 성적 확인", description = "모든 성적 확인")
    public List<StudentScore> findAll(){
        return service.findAll();
    }

    @GetMapping("/id/{id}")
    @Operation(summary = "id 검색", description = "id로 성적 확인")
    public StudentScore findById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping("/name/{name}")
    @Operation(summary = "name 검색", description = "name으로 성적 확인")
    public StudentScore findByName(@PathVariable String name){
        return service.findByName(name);
    }

    @GetMapping("/Top3")
    @Operation(summary = "Top3ByScore", description = "점수 높은 순으로 3명 조회")
    public List<StudentScore> findTop3ByScore(){
        return service.findTop3ByOrderByScore();
    }

    @PutMapping
    @Operation(summary = "성적 수정", description = "score 수정")
    public StudentScore update(@RequestBody StudentScore request){
        return service.update(request);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "성적 삭제", description = "학생id로 성적 삭제")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}

package com.example.week10;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/results")
@RequiredArgsConstructor
@Tag(name = "ResultAPI", description ="성적 관리 API")
public class ResultController {
    private final ResultService resultService;

    @PostMapping("/create")
    @Operation(summary = "성적 추가", description = "name, studentNumber, score로 추가")
    public Result create(@RequestBody Result result) {
        return resultService.save(result);
    }

    @GetMapping("/all")
    @Operation(summary = "전체 조회", description = "name, studentNumber, score 확인 가능")
    public List<Result> findAll() {
        return resultService.findAll();
    }

    @GetMapping("/id/{id}")
    @Operation(summary = "ID로 찾기", description = "id를 입력하면 성적 조회 가능")
    public Result findById(@PathVariable Long id) {
        return resultService.findById(id);
    }

    @GetMapping("/name/{name}")
    @Operation(summary = "이름으로 찾기", description = "이름을 입력하면 성적 조회 가능")
    public Result findByName(@PathVariable String name) {
        return resultService.findByName(name);
    }

    @GetMapping("/Top3")
    @Operation(summary = "점수 높은 순 3명 조회", description = "점수 높은 순으로 3명 조회 가능")
    public List<Result> findTop3ByOrderByScoreDesc() {
        return resultService.findTop3ByOrderByScoreDesc();
    }

    @PutMapping()
    @Operation(summary = "수정하기", description = "name, studentNumber, score 수정 가능")
    public Result update(@RequestBody Result request) {
        return resultService.update(request);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "id로 삭제하기", description = "id를 입력하면 성적표에서 삭제")
    public void delete(@PathVariable Long id) {
        resultService.delete(id);
    }
}
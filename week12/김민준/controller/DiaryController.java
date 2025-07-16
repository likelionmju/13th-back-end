package com.example.diary_server.controller;

import com.example.diary_server.dto.DiaryRequest;
import com.example.diary_server.dto.DiaryResponse;
import com.example.diary_server.service.DiaryService;
import org.springframework.web.bind.annotation.*;
import java.time.YearMonth;
import java.util.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/api/diaries")
public class DiaryController {

    private final DiaryService diaryService;

    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }
    // 1. POST /api/diaries
    @Operation(summary = "일기 생성", description = "새로운 일기 데이터를 등록합니다.")
    @PostMapping
    public DiaryResponse createDiary(@RequestBody DiaryRequest diaryRequest) {
        return diaryService.createDiary(diaryRequest);
    }
    // 2. GET /api/diaries?month=2025-07
    @Operation(summary = "월별 일기 목록 조회", description = "지정한 월(예: 2025-07)에 해당하는 모든 일기를 조회합니다.")
    @GetMapping
    public List<DiaryResponse> getDiariesByMonth(
            @Parameter(description = "조회할 월 (예: 2025-07)", example = "2025-07")
            @RequestParam("month") YearMonth yearMonth
    ){
        return diaryService.getMonthlyDiaries(yearMonth);
    }
    // 3. GET /api/diaries/3
    @Operation(summary = "ID로 일기 조회", description = "ID를 통해 특정 일기를 조회합니다.")
    @GetMapping("/{id}")
    public DiaryResponse getById(@PathVariable Long id) {
        return diaryService.getDiaryById(id);
    }
    // 4. PUT /api/diaries/3
    @Operation(summary = "일기 수정", description = "ID를 통해 기존 일기를 새로운 내용으로 수정합니다.")
    @PutMapping("/{id}")
    public DiaryResponse updateDiary(
            @PathVariable Long id,
            @RequestBody DiaryRequest diaryRequest
    ) {
        return diaryService.updateDiary(id, diaryRequest);
    }
    // 5. DELETE /api/diaries/3
    @Operation(summary = "일기 삭제", description = "ID를 통해 특정 일기를 삭제합니다.")
    @DeleteMapping("/{id}")
    public Map<String, String> diaryDelete(@PathVariable Long id) {
        return diaryService.deleteDiary(id);
    }
}

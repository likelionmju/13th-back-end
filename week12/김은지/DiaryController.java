package com.example.diary_server.controller;

import com.example.diary_server.dto.DiaryRequest;
import com.example.diary_server.dto.DiaryResponse;
import com.example.diary_server.entity.Diary;

import java.time.YearMonth;

import com.example.diary_server.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/diaries")
@RequiredArgsConstructor
public class DiaryController {
    private final DiaryService diaryService;

    //diary에 추가
    @PostMapping
    public DiaryResponse create(@RequestBody DiaryRequest request) {
        return diaryService.createDiary(request);

    }

    //날짜로 찾기
    @GetMapping
    public List<DiaryResponse> findByMonth(@RequestParam("month") YearMonth yearMonth) {
        return diaryService.findByMonth(yearMonth);

    }

    //id로 찾기
    @GetMapping("/{id}")
    public DiaryResponse findById(@PathVariable Long id) {
        return diaryService.findById(id);
    }

    //일기 수정, id 를 받아서 새로 받은 내용으로 덮어쓰기
    @PutMapping("/{id}")
    public DiaryResponse updatdeDiary(@PathVariable Long id, @RequestBody DiaryRequest request) {
        return diaryService.updateDiary(id, request);
    }

    //id로 삭제하기
    @DeleteMapping("/{id}")
    public Map<String, String> deleteDiary(@PathVariable Long id) {
        return diaryService.deleteDiary(id);
    }
}

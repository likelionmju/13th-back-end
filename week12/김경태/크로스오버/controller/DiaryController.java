package com.example.diary_server.controller;

import com.example.diary_server.dto.DiaryRequest;
import com.example.diary_server.dto.DiaryResponse;
import com.example.diary_server.entity.Diary;
import com.example.diary_server.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.YearMonth;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/diaries")
public class DiaryController {
    private final DiaryService diaryService;

    @PostMapping
    public DiaryResponse createDiary(@RequestBody DiaryRequest diary){
        Diary saved = diaryService.saveDiary(diary);
        return DiaryResponse.fromEntity(saved);
    }

    @PutMapping("/{id}")
    public DiaryResponse updateDiary(@PathVariable Long id, @RequestBody DiaryRequest request){
        Diary update = diaryService.update(id, request);
        return DiaryResponse.fromEntity(update);
    }

    @DeleteMapping("/{id}")
    public Map<String, String> deleteDiary(@PathVariable Long id) {
        return diaryService.deleteDiary(id);
    }

    @GetMapping("/{id}")
    public DiaryResponse getDiary(@PathVariable Long id){
        Diary diary = diaryService.findById(id);
        return DiaryResponse.fromEntity(diary);
    }

    @GetMapping
    public List<DiaryResponse> getDiariesByMonth (@RequestParam("month") YearMonth yearMonth){
        return diaryService.findByMonth(yearMonth);
    }
}

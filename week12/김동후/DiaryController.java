package com.example.diary_server.controller;

import com.example.diary_server.dto.DiaryRequest;
import com.example.diary_server.dto.DiaryResponse;
import com.example.diary_server.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.YearMonth;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/diaries")
@RequiredArgsConstructor
public class DiaryController {

    private final DiaryService diaryService;

    @PostMapping("/create")
    public DiaryResponse createDiary(@RequestBody DiaryRequest request) {
        return diaryService.createDiary(request);
    }

    @GetMapping
    public List<DiaryResponse> getDiariesByMonth(@RequestParam("month") YearMonth yearMonth) {
        return diaryService.getDiariesByMonth(yearMonth);
    }


    @GetMapping("/{id}")
    public DiaryResponse getDiary(@PathVariable Long id) { /// getDiaryById/!!!
        return diaryService.getDiary(id);
    }

    @PutMapping("/{id}")
    public DiaryResponse updateDiary(@PathVariable Long id, @RequestBody DiaryRequest request) {
        return diaryService.updateDiary(id, request);
    }


    @DeleteMapping("/{id}")
    public Map<String, String> deleteDiary(@PathVariable Long id) {
        return diaryService.deleteDiary(id);
    }
}

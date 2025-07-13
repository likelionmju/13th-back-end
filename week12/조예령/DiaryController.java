package com.example.diaryserver.controller;

import com.example.diaryserver.dto.DiaryCreateDto;
import com.example.diaryserver.dto.DiaryResponseDto;
import com.example.diaryserver.entity.DiaryEntity;
import com.example.diaryserver.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.HashMap;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DiaryController {
    private final DiaryService diaryService;

    @PostMapping("/diaries")
    public DiaryResponseDto create(@RequestBody DiaryCreateDto diaryCreateDto) {
        DiaryEntity saved = diaryService.save(diaryCreateDto);
        return DiaryResponseDto.fromEntity(saved);
    }

    @GetMapping("/diaries")
    public List<DiaryResponseDto> getDiariesByMonth(@RequestParam("month") String monthStr) {
        try {
            YearMonth yearMonth = YearMonth.parse(monthStr, DateTimeFormatter.ofPattern("yyyy-MM"));
            return diaryService.findByCreatedDateBetween(yearMonth);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid month format. Use 'yyyy-MM' format (e.g., '2025-07')");
        }
    }

    @GetMapping("/diaries/{id}")
    public DiaryResponseDto findById(@PathVariable Long id) {
        Optional<DiaryEntity> diary = diaryService.findById(id);
        if (diary.isEmpty()) {
            throw new RuntimeException("Diary not found with id: " + id);
        }
        return DiaryResponseDto.fromEntity(diary.get());
    }

    @PutMapping("/diaries/{id}")
    public DiaryResponseDto update(@PathVariable Long id, @RequestBody DiaryCreateDto diaryCreateDto) {
        return diaryService.update(id, diaryCreateDto);
    }

    @DeleteMapping("/diaries/{id}")
    public Map<String, String> deleteDiary(@PathVariable Long id){
        return diaryService.delete(id);
    }

}

package example.diary_server.controller;

import example.diary_server.dto.DiaryRequest;
import example.diary_server.dto.DiaryResponse;
import example.diary_server.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import java.time.YearMonth;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/diaries")
public class DiaryController {

    private final DiaryService diaryService;

    @GetMapping
    public List<DiaryResponse> getDiariesByMonth(
            @RequestParam("month") @DateTimeFormat(pattern = "yyyy-MM") YearMonth yearMonth
    ) {
        return diaryService.getDiariesByMonth(yearMonth);
    }

    @GetMapping("/{id}")
    public DiaryResponse getDiaryById(@PathVariable Long id) {
        return diaryService.getDiaryById(id);
    }

    @PostMapping
    public DiaryResponse createDiary(@RequestBody DiaryRequest request) {
        return diaryService.createDiary(request);
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
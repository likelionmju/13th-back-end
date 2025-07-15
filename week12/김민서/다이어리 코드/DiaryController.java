package hello.diary_server.controller;

import hello.diary_server.DTO.DiaryCreateDto;
import hello.diary_server.DTO.DiaryResponseDto;
import hello.diary_server.entity.Diary;
import hello.diary_server.service.DiaryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.YearMonth;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contacts")
public class DiaryController {
    private final DiaryService diaryService;

    @PostMapping("/create")
    public DiaryResponseDto create(@RequestBody @Valid DiaryCreateDto contactCreateDto) {
        Diary saved = diaryService.save(contactCreateDto);
        return DiaryResponseDto.fromEntity(saved);
    }

    @GetMapping("/all")
    public List<Diary> findAll() {
        return diaryService.findAll();
    }

    @GetMapping("/id/{id}")
    public Diary findById(@PathVariable Long id) {
        return diaryService.findById(id);
    }

    @GetMapping("/by-month")
    public List<DiaryResponseDto> getDiariesByMonth(@RequestParam("month") YearMonth yearMonth) {
        List<Diary> diaries = diaryService.findByMonth(yearMonth);
        return diaries.stream()
                .map(DiaryResponseDto::fromEntity)
                .toList();
    }

    @PutMapping("/{id}")
    public Diary update(@PathVariable Long id, @RequestBody Diary request) {
        return diaryService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public Map<String, String> deleteDiary(@PathVariable Long id) {
        return diaryService.deleteDiary(id);
    }

}

package hello.diary_server.controller;

import hello.diary_server.dto.request.CreateUpdateDiaryRequestDto;
import hello.diary_server.dto.response.EntityResponseDto;
import hello.diary_server.service.DiaryService;
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

    @PostMapping
    public EntityResponseDto save(@RequestBody CreateUpdateDiaryRequestDto dto) {
        return diaryService.save(dto);
    }

    @GetMapping
    public List<EntityResponseDto> findMonth(@RequestParam YearMonth month) {
        return diaryService.findByMonth(month);
    }

    @GetMapping("/{id}")
    public EntityResponseDto findById(@PathVariable Long id) {
        return diaryService.findById(id);
    }

    @PutMapping("/{id}")
    public EntityResponseDto update(@PathVariable Long id, @RequestBody CreateUpdateDiaryRequestDto dto) {
        return diaryService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public Map<String, String> deleteById(@PathVariable Long id) {

        return diaryService.deleteById(id);
    }

}

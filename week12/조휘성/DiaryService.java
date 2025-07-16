package example.diary_server.service;

import example.diary_server.dto.DiaryRequest;
import example.diary_server.dto.DiaryResponse;
import example.diary_server.entity.Diary;
import example.diary_server.repository.DiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DiaryService {

    private final DiaryRepository diaryRepository;

    public List<DiaryResponse> getDiariesByMonth(YearMonth yearMonth) {
        LocalDateTime start = yearMonth.atDay(1).atStartOfDay();
        LocalDateTime end = yearMonth.atEndOfMonth().atTime(23,59,59);

        return diaryRepository.findAllByCreatedDateBetween(start, end)
                .stream()
                .map(DiaryResponse::from)
                .collect(Collectors.toList());
    }

    public DiaryResponse getDiaryById(Long id) {
        Diary diary = diaryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("일기를 찾을 수 없습니다."));
        return DiaryResponse.from(diary);
    }

    public DiaryResponse createDiary(DiaryRequest request) {
        LocalDateTime createdDate = LocalDateTime.ofInstant(
                Instant.ofEpochMilli(request.getCreatedDate()),
                ZoneId.of("Asia/Seoul")
        );

        Diary diary = new Diary(createdDate, request.getEmotionId(), request.getContent());
        return DiaryResponse.from(diaryRepository.save(diary));
    }

    public DiaryResponse updateDiary(Long id, DiaryRequest request) {
        Diary diary = diaryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("일기를 찾을 수 없습니다."));

        LocalDateTime createdDate = LocalDateTime.ofInstant(
                Instant.ofEpochMilli(request.getCreatedDate()),
                ZoneId.of("Asia/Seoul")
        );

        diary.update(createdDate, request.getEmotionId(), request.getContent());
        return DiaryResponse.from(diary);
    }

    public Map<String, String> deleteDiary(Long id) {
        diaryRepository.deleteById(id);

        // Java 8 호환 방식
        Map<String, String> response = new HashMap<>();
        response.put("message", "일기 삭제 완료");
        return response;
    }
}
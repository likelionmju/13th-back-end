package com.example.diary_server.service;

import com.example.diary_server.dto.DiaryRequest;
import com.example.diary_server.dto.DiaryResponse;
import com.example.diary_server.entity.Diary;
import com.example.diary_server.repository.DiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DiaryService {

    private final DiaryRepository diaryRepository;

    public DiaryResponse createDiary(DiaryRequest request) {
        LocalDateTime createdDate = LocalDateTime.ofInstant(
                Instant.ofEpochMilli(request.getCreatedDate()),
                ZoneId.of("Asia/Seoul")
        );
        Diary diary = new Diary(createdDate, request.getEmotionId(), request.getContent());
        Diary saved = diaryRepository.save(diary);
        return new DiaryResponse(saved);
    }

    public List<DiaryResponse> getDiariesByMonth(YearMonth yearMonth) {
        List<DiaryResponse> result = new ArrayList<>();

        LocalDateTime start = yearMonth.atDay(1).atStartOfDay();
        LocalDateTime end = yearMonth.atEndOfMonth().atTime(23, 59, 59);

        for (Diary item : diaryRepository.findAllByCreatedDateBetween(start, end)) {
            DiaryResponse response = new DiaryResponse(item);
            result.add(response);
        }

        return result;
    }

    public DiaryResponse getDiary(Long id) {
        Optional<Diary> optionalDiary = diaryRepository.findById(id);
        Diary diary = optionalDiary.orElseThrow();
        return new DiaryResponse(diary);
    }

    public DiaryResponse updateDiary(Long id, DiaryRequest request) {
        Optional<Diary> optionalDiary = diaryRepository.findById(id);
        Diary diary = optionalDiary.orElseThrow();

        LocalDateTime createdDate = LocalDateTime.ofInstant(
                Instant.ofEpochMilli(request.getCreatedDate()),
                ZoneId.of("Asia/Seoul")
        );
        diary.update(createdDate, request.getEmotionId(), request.getContent());
        Diary updated = diaryRepository.save(diary);

        return new DiaryResponse(updated);
    }

    public Map<String, String> deleteDiary(Long id) {
        Optional<Diary> optionalDiary = diaryRepository.findById(id);
        Diary diary = optionalDiary.orElseThrow();
        diaryRepository.delete(diary);
        return Map.of("message", "일기 삭제 완료");
    }
}

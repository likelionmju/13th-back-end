package com.example.diary_server.service;

import com.example.diary_server.dto.DiaryRequest;
import com.example.diary_server.dto.DiaryResponse;
import com.example.diary_server.entity.Diary;
import com.example.diary_server.repository.DiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.*;

@Service
public class DiaryService {

    private final DiaryRepository diaryRepository;

    @Autowired
    public DiaryService(DiaryRepository diaryRepository) {
        this.diaryRepository = diaryRepository;
    }

    public DiaryResponse createDiary(DiaryRequest diaryRequest) {
        Diary diary = diaryRequest.toEntity();
        diaryRepository.save(diary);
        return DiaryResponse.fromEntity(diary);
    }

    public List<DiaryResponse> getMonthlyDiaries (YearMonth yearMonth) {
        List<DiaryResponse> result = new ArrayList<>();

        LocalDateTime start = yearMonth.atDay(1).atStartOfDay(); // 2025-07-01T00:00:00
        LocalDateTime end = yearMonth.atEndOfMonth().atTime(23, 59, 59); // 2025-07-31T23:59:59

        for (Diary item: diaryRepository.findByCreatedDateBetween(start,end)) {
            DiaryResponse diaryResponse = DiaryResponse.fromEntity(item);
            result.add(diaryResponse);
        }
        return result;
    }

    public DiaryResponse getDiaryById(Long id) {
        Optional<Diary> optional = diaryRepository.findById(id);
        if (optional.isPresent()) return DiaryResponse.fromEntity(optional.get());
        return new DiaryResponse(); // 예외처리 (없음)
    }

    public DiaryResponse updateDiary(Long id, DiaryRequest diaryRequest) {
        Optional<Diary> optional = diaryRepository.findById(id);
        if (optional.isPresent()) {
            Diary diary = optional.get();
            diaryRequest.updateEntity(diary);
            diaryRepository.save(diary);
            return DiaryResponse.fromEntity(diary);
        }
        return new DiaryResponse(); // 예외처리 (없음)
    }

    public Map<String, String> deleteDiary(Long id) {
        Optional<Diary> optional = diaryRepository.findById(id);
        if (optional.isPresent()) {
            diaryRepository.deleteById(id);
            Map<String, String> message = new HashMap<>();
            message.put("message", "삭제되었습니다");
            return message;
        }
        Map<String, String> error = new HashMap<>();
        error.put("message", "해당 일기를 찾을 수 없습니다");
        return error;
    }

}

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

    //일기생성
    public DiaryResponse createDiary(DiaryRequest request) {
        Diary diary = new Diary();
        // Long -> LocalDateTime 변환
        Instant instant = Instant.ofEpochMilli(request.getCreatedDate());
        LocalDateTime createdDate = LocalDateTime.ofInstant(instant, ZoneId.of("Asia/Seoul"));

        diary.setCreatedDate(createdDate);
        diary.setEmotionId(request.getEmotionId());
        diary.setContent(request.getContent());
        Diary saved = diaryRepository.save(diary);
        long timestamp = saved.getCreatedDate()
                .atZone(ZoneId.of("Asia/Seoul")) // 시간대 입혀주고
                .toInstant()                     // Instant로 변환
                .toEpochMilli();

        return new DiaryResponse(
                saved.getId(),
                saved.getContent(),
                saved.getEmotionId(),
                timestamp
        );

    }

    //월별조회
    public List<DiaryResponse> findByMonth(YearMonth yearMonth) {
        // 시작일
        LocalDateTime start = yearMonth.atDay(1).atStartOfDay();
        // 종료일
        LocalDateTime end = yearMonth.atEndOfMonth().atTime(23, 59, 59);

        List<Diary> diaries = diaryRepository.findAllByCreatedDateBetween(start, end);
        List<DiaryResponse> result = new ArrayList<>();
    //List<Diary>를 DiaryResponse 타입으로 바꿔서 줘야함 -> for 문으로 처리
        for (Diary diary : diaries) {
            long timestamp = diary.getCreatedDate()
                    .atZone(ZoneId.of("Asia/Seoul"))
                    .toInstant()
                    .toEpochMilli();

            DiaryResponse response = new DiaryResponse(
                    diary.getId(),
                    diary.getContent(),
                    diary.getEmotionId(),
                    timestamp
            );

            result.add(response);
        }

        return result;
    }

    //id로 조회
    public DiaryResponse findById(Long id) {
        Diary diary = diaryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("일기를 찾을 수 없습니다"));
        long timestamp = diary.getCreatedDate()
                .atZone(ZoneId.of("Asia/Seoul"))
                .toInstant()
                .toEpochMilli();
        return new DiaryResponse(
                diary.getId(),
                diary.getContent(),
                diary.getEmotionId(),
                timestamp
        );
    } // 내용 수정

    public DiaryResponse updateDiary(Long id, DiaryRequest request) {
        Diary diary = diaryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("일기를 찾을 수 없습니다"));
        Instant instant = Instant.ofEpochMilli(request.getCreatedDate());
        LocalDateTime createdDate = LocalDateTime.ofInstant(instant, ZoneId.of("Asia/Seoul"));

        diary.setCreatedDate(createdDate);
        diary.setEmotionId(request.getEmotionId());
        diary.setContent(request.getContent());

        Diary updated = diaryRepository.save(diary);
        long timestamp = updated.getCreatedDate()
                .atZone(ZoneId.of("Asia/Seoul"))
                .toInstant()
                .toEpochMilli();
        return new DiaryResponse(
                updated.getId(),
                updated.getContent(),
                updated.getEmotionId(),
                timestamp
        );
    }

    // 삭제
    public Map<String, String> deleteDiary(Long id) {
        diaryRepository.deleteById(id);
        return Map.of("message", "일기 삭제 완료");
    }
}


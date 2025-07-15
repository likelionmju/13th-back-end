package com.example.diaryserver.service;

import com.example.diaryserver.dto.DiaryCreateDto;
import com.example.diaryserver.dto.DiaryResponseDto;
import com.example.diaryserver.entity.DiaryEntity;
import com.example.diaryserver.repository.DiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.*;

@Service
@RequiredArgsConstructor
public class DiaryService {

    private final DiaryRepository diaryRepository;

    public DiaryEntity save(DiaryCreateDto dto) {
        Instant instant = Instant.ofEpochMilli(dto.getCreatedDate());
        LocalDateTime createdDate = LocalDateTime.ofInstant(instant, ZoneId.of("Asia/Seoul"));

        DiaryEntity diaryEntity = new DiaryEntity();
        diaryEntity.setCreatedDate(createdDate);
        diaryEntity.setEmotionId(dto.getEmotionId());
        diaryEntity.setContent(dto.getContent());

        DiaryEntity saved = diaryRepository.save(diaryEntity);
        return saved;
    }

    public List<DiaryResponseDto> findByCreatedDateBetween(YearMonth yearMonth) {
        List<DiaryResponseDto> result = new ArrayList<>();

        LocalDateTime start = yearMonth.atDay(1).atStartOfDay();
        LocalDateTime end = yearMonth.atEndOfMonth().atTime(23, 59, 59);

        for(DiaryEntity item: diaryRepository.findByCreatedDateBetween(start, end)) {
            DiaryResponseDto responseDto = DiaryResponseDto.fromEntity(item);
            result.add(responseDto);
        }
        return result;
    }

    public Optional<DiaryEntity> findById(Long id) {
        return diaryRepository.findById(id);
    }

    public DiaryResponseDto update(Long id, DiaryCreateDto dto) {
        Optional<DiaryEntity> existingDiary = diaryRepository.findById(id);
        if (existingDiary.isEmpty()) {
            throw new RuntimeException("Diary not found with id: " + id);
        }

        Instant instant = Instant.ofEpochMilli(dto.getCreatedDate());
        LocalDateTime createdDate = LocalDateTime.ofInstant(instant, ZoneId.of("Asia/Seoul"));

        DiaryEntity diaryEntity = existingDiary.get();
        diaryEntity.setCreatedDate(createdDate);
        diaryEntity.setEmotionId(dto.getEmotionId());
        diaryEntity.setContent(dto.getContent());

        DiaryEntity saved = diaryRepository.save(diaryEntity);

        return DiaryResponseDto.fromEntity(saved);

    }

    public Map<String, String> delete(Long id) {
        diaryRepository.deleteById(id);
        HashMap<String, String> map = new HashMap<>();
        map.put("message", "삭제 완료");
        return map;

    }
}


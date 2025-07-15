package hello.diary_server.service;

import hello.diary_server.DTO.DiaryCreateDto;
import hello.diary_server.entity.Diary;
import hello.diary_server.repository.DiaryRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DiaryService {
    private final DiaryRepository diaryRepository;


    public Diary save(@Valid DiaryCreateDto dto) {
        Diary contact = new Diary();
        Instant instant = Instant.ofEpochMilli(dto.getCreatedDate());
        LocalDateTime createdDate = LocalDateTime.ofInstant(instant, ZoneId.of("Asia/Seoul"));
        contact.setCreatedDate(createdDate);
        contact.setEmotionId(dto.getEmotionId());
        contact.setContent(dto.getContent());
        Diary saved = diaryRepository.save(contact);

        return saved;
    }

    public List<Diary> findAll() {
        return diaryRepository.findAll();
    }

    public Diary findById(Long id) {
        return diaryRepository.findById(id).get();
    }

    public List<Diary> findByMonth(YearMonth yearMonth) {
        LocalDateTime start = yearMonth.atDay(1).atStartOfDay();
        LocalDateTime end = yearMonth.atEndOfMonth().atTime(23, 59, 59);
        return diaryRepository.findAllByCreatedDateBetween(start, end);
    }


    public Diary update(Long id, Diary request) {
        Diary diary = diaryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(id + "가 존재하지 않습니다."));
        diary.setEmotionId(request.getEmotionId());
        diary.setContent(request.getContent());
        return diaryRepository.save(diary);
    }

    public Map<String, String> deleteDiary(Long id) {
        diaryRepository.deleteById(id);
        return Map.of("message", "일기 삭제 완료");
    }
}


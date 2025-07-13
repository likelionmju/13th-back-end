package com.example.diaryserver.dto;

import com.example.diaryserver.entity.DiaryEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Getter
public class DiaryResponseDto {
    private Long id;
    private Long createdDate;
    private Long emotionId;
    private String content;

    public DiaryResponseDto(Long id, Long createdDate, Long emotionId, String content) {
        this.id = id;
        this.createdDate = createdDate;
        this.emotionId = emotionId;
        this.content = content;
    }

    private Long convertToMs(LocalDateTime time) {
        Instant instant = time.atZone(ZoneId.of("Asia/Seoul")).toInstant();
        return instant.toEpochMilli();
    }

    public static DiaryResponseDto fromEntity(DiaryEntity d) {
        return new DiaryResponseDto(
                d.getId(),
                d.getCreatedDate().atZone(ZoneId.of("Asia/Seoul")).toInstant().toEpochMilli(),
                d.getEmotionId(),
                d.getContent()
                );
    }
}

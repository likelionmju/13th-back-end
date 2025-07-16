package com.example.diary_server.dto;

import com.example.diary_server.entity.Diary;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;


// front 가 원하는 정보를 뽑아서 주는 ...
@Getter
@NoArgsConstructor
public class DiaryResponse {
    @NotNull
    private Long id;
    @Schema(description = "작성 일시 (밀리초, timestamp)", example = "1720341600000")
    @NotNull
    private Long createdDate;
    @NotNull
    private int emotionId;
    @NotNull
    private String content;

    public DiaryResponse(
            Long id,
            Long createdDate,
            int emotionId,
            String content) {
        this.id = id;
        this.createdDate = createdDate;
        this.emotionId = emotionId;
        this.content = content;
    }

    public static DiaryResponse fromEntity(Diary diary) {
        return new DiaryResponse(
                diary.getId(),
                convertToMillis(diary.getCreatedDate()),
                diary.getEmotionId(),
                diary.getContent()
        );
    }

    private static Long convertToMillis(LocalDateTime dataTime) {
        Instant instant = dataTime.atZone(ZoneId.of("Asia/Seoul")).toInstant();
        return instant.toEpochMilli();
    }
}

package com.example.diary_server.dto;

import com.example.diary_server.entity.Diary;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Data
@Getter
@Setter
@AllArgsConstructor
@Builder
public class DiaryRequest {
    @Schema(description = "작성 일시 (밀리초, timestamp )", example = "1720341600000")
    @NotNull
    private Long createdDate;
    @NotNull
    private int emotionId;
    @NotNull
    private String content;

    public Diary toEntity() {
        return Diary.builder()
                .createdDate(toLocalDateTime())
                .emotionId(emotionId)
                .content(content)
                .build();
    }

    public LocalDateTime toLocalDateTime() {
        return Instant.ofEpochMilli(this.createdDate)
                .atZone(ZoneId.of("Asia/Seoul"))
                .toLocalDateTime();
    }

    public void updateEntity(Diary diary) {
        diary.setCreatedDate(this.toLocalDateTime());
        diary.setContent(this.content);
        diary.setEmotionId(this.emotionId);
    }
}

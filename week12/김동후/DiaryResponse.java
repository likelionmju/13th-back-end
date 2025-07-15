package com.example.diary_server.dto;

import com.example.diary_server.entity.Diary;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Getter
@NoArgsConstructor
public class DiaryResponse {
    private Long id;
    private Long createdDate;
    private Integer emotionId;
    private String content;

    public DiaryResponse(Diary diary) {
        this.id = diary.getId();
        this.createdDate = convertToMe(diary.getCreatedDate());
        this.emotionId = diary.getEmotionId();
        this.content = diary.getContent();
    }

    public static DiaryResponse fromEntity(Diary diary) {
        return new DiaryResponse(diary);
    }

    private Long convertToMe(LocalDateTime localDateTime) {
        return localDateTime.atZone(ZoneId.of("Asia/Seoul"))
                .toInstant()
                .toEpochMilli();
    }
}

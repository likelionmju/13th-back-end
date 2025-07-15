package com.example.diary_server.dto;

import com.example.diary_server.entity.Diary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.ZoneId;

@Getter
@Setter
@AllArgsConstructor
public class DiaryResponse {
    private Long id;
    private Long createdDate; // timestamp
    private int emotionId;
    private String content;

    public static DiaryResponse fromEntity(Diary diary) {
        long timestamp = diary.getCreatedDate()
                .atZone(ZoneId.of("Asia/Seoul"))
                .toInstant()
                .toEpochMilli();

        return new DiaryResponse(
                diary.getId(),
                timestamp,
                diary.getEmotionId(),
                diary.getContent()
        );
    }
}

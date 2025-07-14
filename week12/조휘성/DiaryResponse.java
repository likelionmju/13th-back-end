package example.diary_server.dto;

import example.diary_server.entity.Diary;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Getter
@AllArgsConstructor
public class DiaryResponse {
    private Long id;
    private Long createdDate;
    private int emotionId;
    private String content;

    public static DiaryResponse from(Diary diary) {
        Instant instant = diary.getCreatedDate()
                .atZone(ZoneId.of("Asia/Seoul"))
                .toInstant();
        long timestamp = instant.toEpochMilli();

        return new DiaryResponse(
                diary.getId(),
                timestamp,
                diary.getEmotionId(),
                diary.getContent()
        );
    }
}
package hello.diary_server.DTO;

import hello.diary_server.entity.Diary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Getter
@Setter
@AllArgsConstructor
public class DiaryResponseDto {
    private Long id;
    private Long createdDate;
    private String emotionId;
    private String content;

    public static DiaryResponseDto fromEntity(Diary d) {
        LocalDateTime createdDate = d.getCreatedDate();
        Instant instant = createdDate.atZone(ZoneId.of("Asia/Seoul")).toInstant();
        long timestamp = instant.toEpochMilli();

        return new DiaryResponseDto(
                d.getId(),
                timestamp,
                d.getEmotionId(),
                d.getContent()
        );
    }
}

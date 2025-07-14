package example.diary_server.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiaryRequest {
    private Long createdDate;

    private int emotionId;

    private String content;
}

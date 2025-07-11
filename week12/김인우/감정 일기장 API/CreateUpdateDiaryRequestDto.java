package hello.diary_server.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUpdateDiaryRequestDto {
    private Long createdDate;
    private Long emotionId;
    private String content;
}

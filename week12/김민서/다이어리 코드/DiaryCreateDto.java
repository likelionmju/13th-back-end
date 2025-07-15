package hello.diary_server.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiaryCreateDto {
    @NotNull(message = "날짜는 필수 입력값입니다.")
    private Long createdDate;
    @NotBlank(message = "emotionId는 필수 입력값입니다.")
    private String emotionId;
    @NotBlank(message = "content는 필수 입력값입니다.")
    private String content;

}

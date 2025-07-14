package example.diary_server.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Diary {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdDate;
    private int emotionId;

    @Lob
    private String content;

    public Diary(LocalDateTime createdDate, int emotionId, String content) {
        this.createdDate = createdDate;
        this.emotionId = emotionId;
        this.content = content;
    }

    public void update(LocalDateTime createdDate, int emotionId, String content) {
        this.createdDate = createdDate;
        this.emotionId = emotionId;
        this.content = content;
    }
}

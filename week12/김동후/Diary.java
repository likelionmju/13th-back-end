package com.example.diary_server.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Diary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdDate;
    private Integer emotionId;
    private String content;

    public Diary(LocalDateTime createdDate, Integer emotionId, String content) {
        this.createdDate = createdDate;
        this.emotionId = emotionId;
        this.content = content;
    }

    public void update(LocalDateTime createdDate, Integer emotionId, String content) {
        this.createdDate = createdDate;
        this.emotionId = emotionId;
        this.content = content;
    }
}

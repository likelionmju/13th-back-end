package com.example.diary_server.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class DiaryRequest {
    private String content;
    private int emotionId;
    private Long createdDate;


}

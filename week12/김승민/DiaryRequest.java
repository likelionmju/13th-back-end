package com.example.diary_server.dto;

import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
public class DiaryRequest {
    private Long createdDate; // timestamp
    private int emotionId;
    private String content;
}

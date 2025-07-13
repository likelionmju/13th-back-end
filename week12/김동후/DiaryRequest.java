package com.example.diary_server.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DiaryRequest {
    private Long createdDate;
    private Integer emotionId;
    private String content;
}

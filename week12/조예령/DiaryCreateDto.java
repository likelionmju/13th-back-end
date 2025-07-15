package com.example.diaryserver.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiaryCreateDto {

    private Long createdDate;

    private Long emotionId;
    private String content;
}

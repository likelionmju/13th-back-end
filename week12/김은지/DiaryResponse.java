package com.example.diary_server.dto;

import com.example.diary_server.entity.Diary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Getter
@Setter
@AllArgsConstructor
public class DiaryResponse {
    private Long id;
    private String content;
    private int emotionId;
    private Long createDate;


}

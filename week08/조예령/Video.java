package com.example.video.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Video {
    private Integer id;
    private Integer userId;
    private String youtubeVideoId;
    private String title;
    private Date uploadDate;
    private int views;
    private int watchTime;
    private int commentsCount;
    private Date createdAt;

}

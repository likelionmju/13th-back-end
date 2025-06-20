package com.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Analysis {

    private Integer id;
    private String video;
    private Integer likes;
    private Integer shares;
    private String playTime;
    private Integer monthlyUploadCount;

    public Analysis(Integer id, String video, Integer likes, Integer shares, String playTime, Integer monthlyUploadCount) {
        this.id = id;
        this.video = video;
        this.likes = likes;
        this.shares = shares;
        this.playTime = playTime;
        this.monthlyUploadCount = monthlyUploadCount;

    }



    public boolean isPopular() {
        return likes != null && likes >= 1000 && shares != null && shares >= 100;

    }

}
package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Analysis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String video;
    private Integer likes;
    private Integer shares;
    private String playTime;
    private Integer monthlyUploadCount;

//    public Analysis(Integer id, String video, Integer likes, Integer shares, String playTime, Integer monthlyUploadCount) {
//        this.id = id;
//        this.video = video;
//        this.likes = likes;
//        this.shares = shares;
//        this.playTime = playTime;
//        this.monthlyUploadCount = monthlyUploadCount;
//
//    }


    public boolean isPopular() {
        return likes != null && likes >= 1000 && shares != null && shares >= 100;

    }

}
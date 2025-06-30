package com.example.repository;

import com.example.model.Analysis;

import java.util.List;

public interface AnalysisRepository {
    List<Analysis> findAll();
    Analysis findByVideo(String name);
    void save(Analysis analysis);
    List<Analysis> findByLikes(Integer likes);
    List<Analysis> findByShares(Integer shares);
    Analysis findByPlayTime(String playTime);
    List<Analysis> findByMonthlyUploadCount(Integer montyUploadCount);
}

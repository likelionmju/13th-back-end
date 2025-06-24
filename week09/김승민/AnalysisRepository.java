package com.example.repository;

import com.example.model.Analysis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnalysisRepository extends JpaRepository<Analysis, Integer> {
//    List<Analysis> findAll();
    Analysis findByVideo(String name);
//    void save(Analysis analysis);
    List<Analysis> findByLikes(Integer likes);
    List<Analysis> findByShares(Integer shares);
    Analysis findByPlayTime(String playTime);
    List<Analysis> findByMonthlyUploadCount(Integer montyUploadCount);
}

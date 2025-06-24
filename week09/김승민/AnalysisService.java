package com.example.service;

import com.example.model.Analysis;
import com.example.repository.AnalysisRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class AnalysisService {

    private final AnalysisRepository analysisRepository;

    @Autowired
    public AnalysisService(AnalysisRepository analysisRepository) {
        this.analysisRepository = analysisRepository;
    }

    public Analysis save(Analysis analysis) {
        return analysisRepository.save(analysis);
    }

    public List<Analysis> findAllAnalyses() {
        return analysisRepository.findAll();
    }

    public Analysis findByVideo(String video) {
        return analysisRepository.findByVideo(video);
    }

    public List<Analysis> findByLikes(Integer likes) {
        return analysisRepository.findByLikes(likes);
    }

    public List<Analysis> findByShares(Integer shares) {
        return analysisRepository.findByShares(shares);
    }

    public Analysis findByPlayTime(String playTime) {
        return analysisRepository.findByPlayTime(playTime);
    }

    public List<Analysis> findByMonthlyUploadCount(Integer monthlyUploadCount) {
        return analysisRepository.findByMonthlyUploadCount(monthlyUploadCount);
    }

    public Analysis register(String video, Integer likes, Integer shares, String playTime, Integer monthlyUploadCount) {
        Analysis analysis = new Analysis(null, video, likes, shares, playTime, monthlyUploadCount);
//        analysis.setId(id);
//        analysis.setVideo(video);
//        analysis.setLikes(likes);
//        analysis.setShares(shares);
//        analysis.setPlayTime(playTime);
//        analysis.setMonthlyUploadCount(monthlyUploadCount);
//        analysisRepository.save(analysis);
        return analysisRepository.save(analysis);
    }
}
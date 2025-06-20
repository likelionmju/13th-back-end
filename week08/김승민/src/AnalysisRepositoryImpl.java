package com.example.repository;

import com.example.model.Analysis;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AnalysisRepositoryImpl implements AnalysisRepository {

    private static Map<Integer, Analysis> map = new HashMap<>();

    @Override
    public void save(Analysis analysis){map.put(analysis.getId(),analysis);}


    @Override
    public Analysis findByVideo(String video) {
        return map.values().stream()
                .filter(analysis -> analysis.getVideo().equals(video))
                .findAny()
                .orElse(null);
    }


    @Override
    public List<Analysis> findByLikes(Integer likes){
        List<Analysis> analysisList = findAll();
        List<Analysis> analysisList2 = new ArrayList<>(map.values());
        List<Analysis> result = new ArrayList<>();
        for (int i = 0; i < analysisList.size(); i++) {
            Analysis analysis = analysisList.get(i);
            int analysisLikes = analysis.getLikes();
            if(analysisLikes == likes){
                result.add(analysis);
            }
        }
        return result;
    }

    @Override
    public List<Analysis> findByShares(Integer shares){
        List<Analysis> analysisList = findAll();
        List<Analysis> analysisList2 = new ArrayList<>(map.values());
        List<Analysis> result = new ArrayList<>();
        for (int i = 0; i < analysisList.size(); i++) {
            Analysis analysis = analysisList.get(i);
            int analysisShares = analysis.getShares();
            if(analysisShares == shares){
                result.add(analysis);
            }
        }
        return result;
    }

    @Override
    public Analysis findByPlayTime(String playTime) {
        return map.values().stream()
                .filter(analysis -> analysis.getPlayTime().equals(playTime))
                .findAny()
                .orElse(null);
    }

    @Override
    public List<Analysis> findByMonthlyUploadCount(Integer monthlyUploadCount){
        List<Analysis> analysisList = findAll();
        List<Analysis> analysisList2 = new ArrayList<>(map.values());
        List<Analysis> result = new ArrayList<>();
        for (int i = 0; i < analysisList.size(); i++) {
            Analysis analysis = analysisList.get(i);
            int analysisMonthlyUploadCount = analysis.getMonthlyUploadCount();
            if(analysisMonthlyUploadCount == monthlyUploadCount){
                result.add(analysis);
            }
        }
        return result;
    }


    @Override
    public List<Analysis> findAll() {
        return new ArrayList<>(map.values());
    }

}
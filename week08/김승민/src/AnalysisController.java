package com.example.controller;

import com.example.model.Analysis;
import com.example.service.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AnalysisController {

    private AnalysisService analysisService;

    @Autowired
    public AnalysisController(AnalysisService analysisService) {
        this.analysisService = analysisService;
    }

    @PostMapping("/analysis")
    public Analysis create(
            @RequestParam Integer id,
            @RequestParam String video,
            @RequestParam Integer likes,
            @RequestParam Integer shares,
            @RequestParam String playTime,
            @RequestParam Integer monthlyUploadCount) {
        return analysisService.register(id, video, likes, shares, playTime, monthlyUploadCount);
    }

    @GetMapping("/analyses/search")
    public Analysis search(@RequestParam("video") String video) {
        Analysis analysis = analysisService.findByVideo(video);
        return analysis;

    }
    @GetMapping("/analyses")
    public List<Analysis> all() {
        return analysisService.findAllAnalyses();
    }

    @GetMapping("/analyses/search/likes")
    public List<Analysis> searchByLikes(@RequestParam Integer likes) {
        return analysisService.findByLikes(likes);
    }
    @GetMapping("/analyses/search/shares")
    public List<Analysis> searchByShares(@RequestParam Integer shares) {
        return analysisService.findByShares(shares);
    }
    @GetMapping("/analyses/search/playTime")
    public Analysis searchByPlayTime(@RequestParam("playTime") String playTime) {
        Analysis analysis = analysisService.findByPlayTime(playTime);
        return analysisService.findByPlayTime(playTime);

    }
    @GetMapping("/analyses/search/monthlyUploadCount")
    public List<Analysis> searchByMonthlyUploadCount(@RequestParam Integer monthlyUploadCount) {
        return analysisService.findByMonthlyUploadCount(monthlyUploadCount);
    }


}
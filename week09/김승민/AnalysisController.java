package com.example.controller;

import com.example.model.Analysis;
import com.example.service.AnalysisService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class AnalysisController {
    private AnalysisService analysisService;

//    @Autowired
    public AnalysisController(AnalysisService analysisService) {
        this.analysisService = analysisService;
    }

    @PostMapping("/analysis")
//    public Analysis create(
//            @RequestParam Integer id,
//            @RequestParam String video,
//            @RequestParam Integer likes,
//            @RequestParam Integer shares,
//            @RequestParam String playTime,
//            @RequestParam Integer monthlyUploadCount) {
//        return analysisService.register(video, likes, shares, playTime, monthlyUploadCount);
//    }
    public Analysis save(@RequestBody Analysis analysis) {
        return analysisService.save(analysis);
    }

    @GetMapping("/analyses/search")
//`    public Analysis search(@RequestParam("video") String video) {
//        Analysis analysis = analysisService.findByVideo(video);
//        return analysis;
//    }
//
        public String search(@RequestParam("video") String video) {
            Analysis analysis =  analysisService.findByVideo(video);
            if (analysis != null) {
                return analysis.getId()+" "+analysis.getVideo();
            }else{
                return null;
            }
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
package com.example.video.controller;

import com.example.video.domain.Video;
import com.example.video.service.VideoService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class VideoController {

    private final VideoService videoService;

    public VideoController(VideoService videoService) {this.videoService = videoService;}

    @PostMapping("api/videos")
    public Video submitVideo(@RequestBody Video video){
        return videoService.register(video);
    }

    @GetMapping("api/videos/search")
    public Video searchVideo(@RequestParam Integer id, Model model){
        Video video = videoService.searchVideo(id);
        model.addAttribute("video", video);
        return video;
    }

    @GetMapping("api/videos/")
    public List<Video> videos(Model model){
        model.addAttribute("videos", videoService.listVideo());
        return videoService.listVideo();
    }

    @GetMapping("api/videos/search/title")
    public List<Video> findByTitle(@RequestParam String title) {return videoService.findByTitle(title);}
}

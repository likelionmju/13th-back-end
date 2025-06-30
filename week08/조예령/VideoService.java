package com.example.video.service;

import com.example.video.domain.Video;
import com.example.video.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VideoService {

    private final VideoRepository videoRepository;

    @Autowired
    public VideoService(VideoRepository videoRepository) {this.videoRepository = videoRepository;}

    public Video searchVideo(Integer id) {return videoRepository.findById(id);}

    public Video register(Video video) {
        return videoRepository.save(video);
    }

    public List<Video> listVideo() {return videoRepository.findAll();}

    public List<Video> findByTitle(String title) {return videoRepository.findByTitle(title);}



}

package com.example.video.service;

import com.example.video.domain.Video;
import com.example.video.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class VideoService {

    private final VideoRepository videoRepository;

    @Autowired
    public VideoService(VideoRepository videoRepository) {this.videoRepository = videoRepository;}

    public Optional<Video> searchVideo(Integer id) {return videoRepository.findById(id);}

    public Video register(Video video) {
        return videoRepository.save(video);
    }

    public List<Video> listVideo() {return videoRepository.findAll();}

    public List<Video> findByTitle(String title) {
        if (title == null) return Collections.emptyList();
        return videoRepository.findByTitleContaining(title);
    }



}

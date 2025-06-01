package com.example.video.repository;

import com.example.video.domain.Video;

import java.util.List;

public interface VideoRepository {

    List<Video> findAll();

    Video findById(Integer id);

    Video save(Video video);

    List<Video> findByTitle(String title);
}

package com.example.video.repository;

import com.example.video.domain.Video;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryVideoRepository implements VideoRepository {

    private static Map<Integer, Video> videoMap = new HashMap<>();
    @Override
    public List<Video> findAll() {
        return new ArrayList<>(videoMap.values());
    }

    @Override
    public Video findById(Integer id) {
        return videoMap.get(id);
    }

    @Override
    public Video save(Video video) {
        videoMap.put(video.getId(), video);
        return video;
    }

    @Override
    public List<Video> findByTitle(String title) {
        List<Video> videoList = findAll();
        List<Video> result = new ArrayList<>();

        if (title == null) return Collections.emptyList();

        for (Video video : videoList) {
            if(video.getTitle() != null && video.getTitle().contains(title)) {
                result.add(video);
            }
        }

        return result;
    }
}

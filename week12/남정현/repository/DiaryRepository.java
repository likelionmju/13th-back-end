package com.example.diary.repository;


import com.example.diary.entity.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
    List<Diary> findAllByCreatedDateBetween(LocalDateTime start, LocalDateTime end);



}

package com.example.diaryserver.repository;

import com.example.diaryserver.entity.DiaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.List;

public interface DiaryRepository extends JpaRepository<DiaryEntity, Long> {

    List<DiaryEntity> findByCreatedDateBetween(LocalDateTime start, LocalDateTime end);

}

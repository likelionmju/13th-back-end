package example.diary_server.repository;

import example.diary_server.entity.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
    List<Diary> findAllByCreatedDateBetween(LocalDateTime start, LocalDateTime end);
}

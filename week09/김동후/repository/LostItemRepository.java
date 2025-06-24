package com.example.week08assignment.repository;

import com.example.week08assignment.domain.LostItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LostItemRepository extends JpaRepository<LostItem, Long> {
    List<LostItem> findByLostLocation(String lostLocation);
}

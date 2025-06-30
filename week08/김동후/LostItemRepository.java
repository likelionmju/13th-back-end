package com.example.week08assignment.repository;

import com.example.week08assignment.domain.LostItem;
import java.util.List;
import java.util.Optional;

public interface LostItemRepository {
    void save(LostItem lostItem);
    Optional<LostItem> findById(Integer lostId);
    List<LostItem> findByLocation(String lostLocation);
    List<LostItem> findAll();

}
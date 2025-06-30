package com.example.practice0505.repository;


import com.example.practice0505.domain.LostItem;

import java.util.List;

public interface LostItemRepository {
    List<LostItem> findAll();

    LostItem save(LostItem lostItem);

    LostItem findById(int id);

    List<LostItem> findByCategory(String category);

}



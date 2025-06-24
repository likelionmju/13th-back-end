package com.example.practice0505.service;

import com.example.practice0505.domain.LostItem;
import com.example.practice0505.repository.LostItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LostItemService {

    private final LostItemRepository lostItemRepositoryImpl;

    public List<LostItem> findAll() {
        return lostItemRepositoryImpl.findAll();
    }

    public List<LostItem> findByCategory(String category) {
        return lostItemRepositoryImpl.findByCategory(category);
    }

    public LostItem save(LostItem lostItem){
        return lostItemRepositoryImpl.save(lostItem);
    }

    public LostItem findById(int id) {
        return lostItemRepositoryImpl.findById(id);
    }
}

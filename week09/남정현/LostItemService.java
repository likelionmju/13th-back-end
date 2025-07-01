package com.example.practice0505.service;

import com.example.practice0505.domain.LostItem;
import com.example.practice0505.repository.LostItemRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class LostItemService {
    private final LostItemRepository lostItemRepository;

    public List<LostItem> findAll() {
        return lostItemRepository.findAll();
    }

    public List<LostItem> findByCategory(String category) {
        return lostItemRepository.findByCategory(category);
    }

    public LostItem save(LostItem lostItem){
        return lostItemRepository.save(lostItem);
    }

    public LostItem findById(long id) {
        return lostItemRepository.findById(id).orElse(null);
    }
}

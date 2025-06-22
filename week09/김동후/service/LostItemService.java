package com.example.week08assignment.service;

import com.example.week08assignment.domain.LostItem;
import com.example.week08assignment.repository.LostItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LostItemService {

    private final LostItemRepository repository;

    public LostItemService(LostItemRepository repository) {
        this.repository = repository;
    }

    public LostItem save(LostItem lostItem) {
        return repository.save(lostItem);
    }

    public List<LostItem> findAll() {
        return repository.findAll();
    }

    public Optional<LostItem> findById(Long id) {
        return repository.findById(id);
    }

    public List<LostItem> findByLocation(String location) {
        return repository.findByLostLocation(location);
    }
}

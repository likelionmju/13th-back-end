package com.example.week08assignment.service;

import com.example.week08assignment.domain.LostItem;
import com.example.week08assignment.repository.LostItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LostItemService {

    private final LostItemRepository repository;

    public LostItemService(LostItemRepository repository) {
        this.repository = repository;
    }

    public void register(LostItem item) {
        repository.save(item);
    }

    public List<LostItem> getAllItems() {return repository.findAll();}


    public Optional<LostItem> getItemById(Integer id) {
        return repository.findById(id);
    }

    public List<LostItem> getItemsByLocation(String location) {
        return repository.findByLocation(location);
    }
}
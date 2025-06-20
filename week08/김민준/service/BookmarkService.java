package com.example.demo.service;

import com.example.demo.domain.Bookmark;
import com.example.demo.repository.BookmarkRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookmarkService {
    private final BookmarkRepository repository;

    public BookmarkService(BookmarkRepository repository) {
        this.repository = repository;
    }

    public Bookmark register(Bookmark bookmark) {
        return repository.save(bookmark);
    }

    public Optional<Bookmark> findById(UUID memberId, UUID placeTag) {
        return repository.findById(memberId, placeTag);
    }

    public List<Bookmark> findByField(String field, String value) {
        return repository.findByField(field, value);
    }
}
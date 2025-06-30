package com.example.demo.controller;

import com.example.demo.domain.Bookmark;
import com.example.demo.service.BookmarkService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/bookmarks")
public class BookmarkController {

    private final BookmarkService service;

    public BookmarkController(BookmarkService service) {
        this.service = service;
    }

    // 1. 북마크등록
    @PostMapping
    public Bookmark register(@RequestBody Bookmark bookmark) {
        return service.register(bookmark);
    }

    // 2. memberId + placeTag로 단건 ㅈ회
    @GetMapping("/{memberId}/{placeTag}")
    public Optional<Bookmark> getById(@PathVariable UUID memberId,
                                      @PathVariable UUID placeTag) {
        return service.findById(memberId, placeTag);
    }

    // 검색
    @GetMapping("/search")
    public List<Bookmark> search(@RequestParam String field,
                                 @RequestParam String value) {
        return service.findByField(field, value);
    }
}
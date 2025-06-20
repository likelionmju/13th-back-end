package com.example.practice0505.controller;

import com.example.practice0505.domain.LostItem;
import com.example.practice0505.service.LostItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LostItemRestController {
    private final LostItemService lostItemService;

    @PostMapping("/api/lostitems")
    public LostItem save(@RequestBody LostItem lostItem) {
        return lostItemService.save(lostItem);
    }

    @GetMapping("/api/lostitems/id")
    public LostItem findById(@RequestParam int lostItemId) {
        return lostItemService.findById(lostItemId);
    }

    @GetMapping("/api/lostitems")
    public List<LostItem> findAll() {
        return lostItemService.findAll();
    }

    @GetMapping("/api/lostitems/category")
    public List<LostItem> findByCategory(@RequestParam String category) {
        return lostItemService.findByCategory(category);
    }


}

package com.example.practice0505.controller;

import com.example.practice0505.domain.LostItem;
import com.example.practice0505.service.LostItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lostitems")
@RequiredArgsConstructor
public class LostItemRestController {
    private final LostItemService lostItemService;

    @PostMapping
    public LostItem save(@RequestBody LostItem lostItem) {
        return lostItemService.save(lostItem);
    }

    @GetMapping("/{id}")
    public LostItem findById(@PathVariable long id) {
        return lostItemService.findById(id);
    }

    @GetMapping
    public List<LostItem> findAll() {
        return lostItemService.findAll();
    }

    @GetMapping("/category")
    public List<LostItem> findByCategory(@RequestParam String category) {
        return lostItemService.findByCategory(category);
    }


}

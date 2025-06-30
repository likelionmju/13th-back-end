package com.example.week08assignment.controller;

import com.example.week08assignment.domain.LostItem;
import com.example.week08assignment.service.LostItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lostItems")
public class LostItemController {

    private final LostItemService service;

    @Autowired
    public LostItemController(LostItemService service) {
        this.service = service;
    }

    @PostMapping("/new")
    public LostItem createItem(@RequestParam Integer lostId,
                                @RequestParam Integer userId,
                                @RequestParam String description,
                                @RequestParam String lostTime,
                                @RequestParam String lostLocation,
                                @RequestParam String storagePlace) {

        LostItem item = new LostItem();
        item.setLostId(lostId);
        item.setUserId(userId);
        item.setDescription(description);
        item.setLostTime(lostTime);
        item.setLostLocation(lostLocation);
        item.setStoragePlace(storagePlace);

        service.register(item);
        return item;
    }

    @GetMapping
    public List<LostItem> getAllItems() {
        return service.getAllItems();
    }


    @GetMapping("/{id}")
    public Optional<LostItem> getItem(@PathVariable Integer id) {
        return service.getItemById(id);
    }

    @GetMapping("/search")
    public List<LostItem> searchByLocation(@RequestParam String location) {
        return service.getItemsByLocation(location);
    }
}
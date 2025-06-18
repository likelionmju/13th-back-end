package com.example.demo.controller;

import com.example.demo.domain.LostItem;
import com.example.demo.domain.LostItemStatus;
import com.example.demo.service.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    private final service service;

    @Autowired
    public Controller(service service){
        this.service = service;
    }

    @PostMapping("/api/lostItem/new")
    public Optional<LostItem> register(@RequestParam Long memberId, Long itemId, String itemName, String division, String lostAddress,
                                       String  lostTime, String status, String saveTime){
        LostItem lostItem = new LostItem();
        lostItem.setMemberId(memberId);
        lostItem.setItemId(itemId);
        lostItem.setItemName(itemName);
        lostItem.setDivision(division);
        lostItem.setLostAddress(lostAddress);
        lostItem.setLostTime(lostTime);
        lostItem.setStatus(status);
        lostItem.setSaveTime(saveTime);

        service.register(lostItem);
        return service.findOne(itemId);
    }

    @GetMapping("/api/lostItem/all")
    public List<LostItem> listLostItem(Model model) {
        return service.findAllItem();
    }

    @GetMapping("/api/lostItem/search/status")
    public List<LostItem> searchStatus(@RequestParam LostItemStatus status){
        return service.findStatus(status);
    }

    @PostMapping("/api/lostItem/status")
    public void update(@RequestParam Long itemId, String status){
        service.upDateStatus(itemId, status);
    }

    @GetMapping("/api/lostItem/search/memberId")
    public List<LostItem> searchMemberId(@RequestParam Long memberId){
        return service.findMemberId(memberId);
    }
}

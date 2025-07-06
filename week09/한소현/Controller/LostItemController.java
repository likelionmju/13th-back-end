package com.example.likelioncatchit.Controller;

import com.example.likelioncatchit.Model.LostItem;
import com.example.likelioncatchit.Model.LostItemStatus;
import com.example.likelioncatchit.Service.LostItemService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/LostItem")
public class LostItemController {
    private final LostItemService service;

    public LostItemController(LostItemService lostItemService){
        service = lostItemService;
    }

    @PostMapping("/register")
    public Optional<LostItem> register(@RequestParam Long memberId, Long itemId, String itemName, String division,
                                       String lostAddress, String  lostTime, LostItemStatus status, String saveTime){
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

    @GetMapping("/all")
    public List<LostItem> listLostItem(Model model) {
        return service.findAll();
    }

    @GetMapping("/search/status")
    public List<LostItem> searchStatus(@RequestParam LostItemStatus status){
        return service.findStatus(status);
    }

    @PostMapping("/update")
    public void update(@RequestParam Long itemId, LostItemStatus status){
        service.upDateStatus(itemId, status);
    }

    @GetMapping("/search/memberId")
    public List<LostItem> searchMemberId(@RequestParam Long memberId){
        return service.findByMemberId(memberId);
    }
}

package com.example.demo.service;


import com.example.demo.repository.repository;
import com.example.demo.domain.LostItem;
import com.example.demo.domain.LostItemStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class service {
    private final repository repository;

    @Autowired
    public service(repository repository){
        this.repository = repository;
    }

    public void register(LostItem lostItem){
        repository.save(lostItem);
    }

    public List<LostItem> findAllItem(){
        return repository.findAll();
    }

    public List<LostItem> findStatus(LostItemStatus status) {return repository.findByStatus(status);}

    public Optional<LostItem> findOne(Long itemId) {
        return repository.findItemId(itemId);
    }

    public void upDateStatus(Long MemberId, String status){
        Optional<LostItem> item = repository.findItemId(MemberId);
        if(item.isPresent()){
            LostItem lostItem = item.get();
            lostItem.setStatus(status);
            repository.update(lostItem);

        }
    }

    public List<LostItem> findMemberId(Long memberId){
        return repository.findByMemberId(memberId);
    }
}

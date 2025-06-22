package com.example.likelioncatchit.Service;

import com.example.likelioncatchit.Model.LostItem;
import com.example.likelioncatchit.Model.LostItemStatus;
import com.example.likelioncatchit.Repository.LostItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LostItemService {
    private final LostItemRepository repository;

    public LostItemService(LostItemRepository lostItemRepository){
        this.repository = lostItemRepository;
    }

    public void register(LostItem lostItem){
        repository.save(lostItem); //JpaRepository save 사용
    }

    public List<LostItem> findAll(){
        return repository.findAll(); //JpaRepository findAll 사용
    }

    public List<LostItem> findStatus(LostItemStatus status) {
        return repository.findByStatus(status);
    }

    public List<LostItem> findByMemberId(Long memberId){
        return repository.findByMemberId(memberId);
    }

    public Optional<LostItem> findOne(Long itemId){
        return repository.findById(itemId); //JpaRepository findById 사용
    }

    public void upDateStatus(Long itemId, LostItemStatus status){
        repository.update(itemId, status);
    }

}

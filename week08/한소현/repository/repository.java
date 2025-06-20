package com.example.demo.repository;

import com.example.demo.domain.LostItem;
import com.example.demo.domain.LostItemStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface repository {
    List<LostItem> findAll();
    Optional<LostItem> findItemId(Long itemId);
    void save(LostItem lostItem);
    List<LostItem> findByStatus(LostItemStatus status);
    LostItem update(LostItem lostItem);
    List<LostItem> findByMemberId(Long memberId);
}

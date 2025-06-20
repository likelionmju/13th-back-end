package com.example.demo.repository;

import com.example.demo.domain.LostItem;
import com.example.demo.domain.LostItemStatus;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class RepositoryImpl implements repository{
    private final Map<Long, LostItem> store = new HashMap<>();

    @Override
    public List<LostItem> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<LostItem> findItemId(Long itemId) {
        return Optional.ofNullable(store.get(itemId));
    }

    @Override
    public void save(LostItem lostItem) {
        store.put(lostItem.getItemId(), lostItem);
    }

    @Override
    public List<LostItem> findByStatus(LostItemStatus status) {
        return store.values().stream()
                .filter(lostItem -> status.equals(lostItem.getStatus()))
                .collect(Collectors.toList());
    }

    @Override
    public LostItem update(LostItem lostItem) {
        store.put(lostItem.getItemId(), lostItem);
        return lostItem;
    }

    @Override
    public List<LostItem> findByMemberId(Long memberId) {
        return store.values().stream()
                .filter(lostItem -> lostItem.getMemberId().equals(memberId))
                .collect(Collectors.toList());
    }
}

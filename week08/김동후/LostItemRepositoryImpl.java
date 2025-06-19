package com.example.week08assignment.repository;

import com.example.week08assignment.domain.LostItem;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class LostItemRepositoryImpl implements LostItemRepository {

    private final Map<Integer, LostItem> store = new HashMap<>();

    @Override
    public void save(LostItem lostItem) {
        store.put(lostItem.getLostId(), lostItem);
    }

    @Override
    public List<LostItem> findAll() {
        return new ArrayList<>(store.values());
    }


    @Override
    public Optional<LostItem> findById(Integer lostId) {
        return Optional.ofNullable(store.get(lostId));
    }

    @Override
    public List<LostItem> findByLocation(String lostLocation) {
        List<LostItem> result = new ArrayList<>();
        for (LostItem item : store.values()) {
            if (item.getLostLocation().equalsIgnoreCase(lostLocation)) {
                result.add(item);
            }
        }
        return result;
    }
}
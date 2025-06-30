package com.example.practice0505.repository;

import com.example.practice0505.domain.LostItem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LostItemRepositoryImpl implements LostItemRepository {

    private Map<Integer, LostItem> map = new HashMap<>();

    @Override
    public List<LostItem> findAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public LostItem save(LostItem lostItem){
        map.put(lostItem.getLostItemId(), lostItem);
        return lostItem;

    }

    @Override
    public List<LostItem> findByCategory(String category) {
        List<LostItem> arraylist1 = findAll();
        List<LostItem> arraylist = new ArrayList<>(map.values());
        List<LostItem> result = new ArrayList<>();

        for (LostItem lostItem : arraylist1) {
            if (lostItem.getCategory().equals(category)) {
                result.add(lostItem);
            }
        }
        return result;

    }

    @Override
    public LostItem findById(int id) {
        return map.get(id);
    }

}

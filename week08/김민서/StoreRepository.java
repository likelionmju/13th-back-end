package hello.week08.repository;

import hello.week08.model.Store;

import java.util.List;

public interface StoreRepository {
    List<Store> findAll();
    Store findById(int id);
    Store findByName(String name);
    void save(Store store);
}

package hello.week09.repository;

import hello.week09.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long> {
    List<Store> findAll();
    Store findById(int id);
    Store findByName(String name);
    Store save(Store store);
}

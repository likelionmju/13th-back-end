package hello.week09.service;

import hello.week09.model.Store;
import hello.week09.repository.StoreRepositoryImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StoreService {

    private final StoreRepositoryImpl storeRepositoryImpl;

    public StoreService(StoreRepositoryImpl storeRepositoryImpl) {
        this.storeRepositoryImpl = storeRepositoryImpl;
    }

    public void register(Store store) {
        storeRepositoryImpl.save(store);
    }

    public List<Store> getAllStores() {
        return storeRepositoryImpl.findAll();
    }

    public List<Store> findAll() {return storeRepositoryImpl.findAll();}

    public Store getStoreById(int id) {
        return storeRepositoryImpl.findById(id);
    }

    public Store getStoreByName(String name) { return storeRepositoryImpl.findByName(name);}
}

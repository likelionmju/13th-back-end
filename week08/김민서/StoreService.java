package hello.week08.service;

import hello.week08.model.Store;
import hello.week08.repository.StoreRepository;
import hello.week08.repository.StoreRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

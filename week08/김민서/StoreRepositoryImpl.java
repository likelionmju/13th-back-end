package hello.week08.repository;

import hello.week08.model.Store;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StoreRepositoryImpl implements StoreRepository {

    private Map<Integer, Store> map = new HashMap<>();

    @Override
    public List<Store> findAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public Store findById(int id) {
        return map.get(id);
    }

    @Override
    public Store findByName(String name) {
        List<Store> stores = new ArrayList<>(map.values());
        for (int i = 0; i < stores.size(); i++) {
            Store store = stores.get(i);
            if (store.getName().equals(name)) {
                return store;
            }
        }
        return null;
    }

    @Override
    public void save(Store store) {
        map.put(store.getId(), store);
    }


}

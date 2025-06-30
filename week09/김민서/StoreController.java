package hello.week09.controller;

import hello.week09.model.Store;
import hello.week09.service.StoreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/store")
public class StoreController {
    public final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping("/register")
    public Store register(@RequestParam Integer id, @RequestParam String name, @RequestParam String address, @RequestParam String hours) {
        Store store = new Store(id, name, address, hours);
        storeService.register(store);
        return store;
    }

    @GetMapping("/all")
    public List<Store> findAll() {
        return storeService.findAll();
    }


    @GetMapping("/search/id")
    public Store getById(@RequestParam Integer id) {
        Store store = storeService.getStoreById(id);
        return store;
    }

    @GetMapping("/search/name")
    public Store getByName(@RequestParam String name) {
        Store store = storeService.getStoreByName(name);
        return store;
    }



}

package example.usecase.controller;

import example.usecase.domain.Restaurant;
import example.usecase.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    private final RestaurantService service;

    @Autowired
    public RestaurantController(RestaurantService service) {
        this.service = service;
    }

    @PostMapping
    public Restaurant save(@RequestBody Restaurant restaurant) {
        return service.save(restaurant);
    }

    @GetMapping("/{id}")
    public Restaurant findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/search")
    public List<Restaurant> findAll() {return service.findAll();}
}

package example.usecase.controller;

import example.usecase.domain.Restaurant;
import example.usecase.service.RestaurantService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    private final RestaurantService service;

    public RestaurantController(RestaurantService service) {
        this.service = service;
    }

    @PostMapping
    public Restaurant register(@RequestBody Restaurant restaurant) {
        return service.register(restaurant);
    }

    @GetMapping("/{id}")
    public Optional<Restaurant> getById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @GetMapping("/search")
    public List<Restaurant> search(
            @RequestParam String field,
            @RequestParam String value) {
        return service.findByField(field, value);
    }
}

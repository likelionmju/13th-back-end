package example.usecase.service;

import example.usecase.domain.Restaurant;
import example.usecase.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {
    private final RestaurantRepository repository;

    public RestaurantService(RestaurantRepository repository) {
        this.repository = repository;
    }

    public Restaurant register(Restaurant restaurant) {
        return repository.save(restaurant);
    }

    public Optional<Restaurant> findById(Integer id) {
        return repository.findById(id);
    }

    public List<Restaurant> findByField(String field, String value) {
        return repository.findByField(field, value);
    }
}

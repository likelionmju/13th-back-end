package example.usecase.repository;

import example.usecase.domain.Restaurant;
import java.util.List;
import java.util.Optional;

public interface RestaurantRepository {
    Restaurant save(Restaurant restaurant);
    Optional<Restaurant> findById(Integer id);
    List<Restaurant> findByField(String field, String value);
}

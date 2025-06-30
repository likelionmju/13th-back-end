package example.usecase.repository;

import example.usecase.domain.Restaurant;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryRestaurantRepository implements RestaurantRepository {
    private static final Map<Integer, Restaurant> store = new HashMap<>();
    private static int sequence = 0;

    @Override
    public Restaurant save(Restaurant restaurant) {
        restaurant.setRestaurantId(++sequence);
        store.put(restaurant.getRestaurantId(), restaurant);
        return restaurant;
    }

    @Override
    public Optional<Restaurant> findById(Integer id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Restaurant> findByField(String field, String value) {
        List<Restaurant> result = new ArrayList<>();
        for (Restaurant r : store.values()) {
            switch (field.toLowerCase()) {
                case "name":
                    if (r.getName().equalsIgnoreCase(value)) result.add(r);
                    break;
                case "location":
                    if (r.getLocation().equalsIgnoreCase(value)) result.add(r);
                    break;
                case "category":
                    if (r.getCategory().equalsIgnoreCase(value)) result.add(r);
                    break;
            }
        }
        return result;
    }
}

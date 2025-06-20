package example.usecase.domain;

public class Restaurant {
    private Integer restaurantId;
    private String name;
    private String location;
    private String category;

    // 생성자
    public Restaurant() {}

    public Restaurant(Integer restaurantId, String name, String location, String category) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.location = location;
        this.category = category;
    }

    // Getter & Setter
    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}


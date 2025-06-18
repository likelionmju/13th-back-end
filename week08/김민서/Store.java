package hello.week08.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Store {
    private Integer id;
    private String name;
    private String address;
    private String hours;

    public Store(Integer id, String name, String address, String hours) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.hours = hours;
    }
}

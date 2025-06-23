package hello.week09.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

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


    public Store() {

    }

}

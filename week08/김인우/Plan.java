package example.demo.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Plan {
    private Integer id;
    private Integer user_id;
    private String title;
    private String description;
}

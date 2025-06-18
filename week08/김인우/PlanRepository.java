package example.demo.repository;

import example.demo.entity.Plan;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface PlanRepository {

    public Plan save(Plan plan);
    public Optional<Plan> findById(Integer id);
    public List<Plan> findByUserId(Integer userId);
    public List<Plan> findByTitle(String title);

}

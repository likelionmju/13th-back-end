package example.demo.repository;

import example.demo.entity.Plan;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryPlanRepository implements PlanRepository {
    private final Map<Integer,Plan> plans = new HashMap<>();

    public Plan save(Plan plan) {
        plans.put(plan.getId(), plan);
        return plan;
    }

    public Optional<Plan> findById(Integer id) {
        return Optional.ofNullable(plans.get(id));
    }

    public List<Plan> findByTitle(String title) {
        List<Plan> result = new ArrayList<>();
        for(Plan plan : plans.values()) {
            if(plan.getTitle().equals(title)) {
                result.add(plan);
            }
        }
        return result;
    }

    public List<Plan> findByUserId(Integer userId) {
        List<Plan> result = new ArrayList<>();
        for(Plan plan : plans.values()) {
            if(plan.getUser_id().equals(userId)) {
                result.add(plan);
            }
        }
        return result;
    }
}

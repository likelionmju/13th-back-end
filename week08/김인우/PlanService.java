package example.demo.service;

import example.demo.entity.Plan;
import example.demo.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlanService {
    private final PlanRepository planRepository;

    public Plan register(Integer id, Integer userId, String title, String description) {
        Plan plan = new Plan();
        plan.setId(id);
        plan.setUser_id(userId);
        plan.setTitle(title);
        plan.setDescription(description);
        return planRepository.save(plan);
    }

    public Optional<Plan> findById(Integer id) {
        return planRepository.findById(id);
    }

    public List<Plan> findByTitle(String title) {
        return planRepository.findByTitle(title);
    }

    public List<Plan> findByUserId(Integer userId) {
        return planRepository.findByUserId(userId);
    }
}

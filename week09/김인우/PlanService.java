package example.demo.service;

import example.demo.entity.Plan;
import example.demo.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PlanService {
    private final PlanRepository planRepository;

    public Plan register(Plan plan) {
        return planRepository.save(plan);
    }

    public Optional<Plan> findById(Long id) {
        return planRepository.findById(id);
    }

    public List<Plan> findByTitle(String title) {
        return planRepository.findByTitle(title);
    }

    public List<Plan> findByUserId(Long userId) {
        return planRepository.findByUserId(userId);
    }
}

package example.demo.repository;

import example.demo.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlanRepository extends JpaRepository<Plan,Long> {
    List<Plan> findByTitle(String title);
    List<Plan> findByUserId(Long userId);
}

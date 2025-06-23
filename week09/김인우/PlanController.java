package example.demo.controller;

import example.demo.entity.Plan;
import example.demo.service.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/plan")
public class PlanController {
    private final PlanService planService;

    @PostMapping("/save")
    public Plan register(@RequestBody Plan plan) {
        return planService.register(plan);
    }

    @GetMapping("/search/id")
    public Optional<Plan> findById(@RequestParam Long id) {
        return planService.findById(id);
    }

    @GetMapping("/search/title")
    public List<Plan> findByTitle(@RequestParam String title) {
        return planService.findByTitle(title);
    }

    @GetMapping("/search/userId")
    public List<Plan> findByUserId(@RequestParam Long userId) {
        return planService.findByUserId(userId);
    }
}

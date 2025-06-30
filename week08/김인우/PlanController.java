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
    public Plan register(
            @RequestParam Integer id,
            @RequestParam Integer userId,
            @RequestParam String title,
            @RequestParam String description
    ) {
        return planService.register(id, userId, title, description);
    }

    @GetMapping("/search/id")
    public Optional<Plan> findById(@RequestParam Integer id) {
        return planService.findById(id);
    }

    @GetMapping("/search/title")
    public List<Plan> findByTitle(@RequestParam String title) {
        return planService.findByTitle(title);
    }

    @GetMapping("/search/userId")
    public List<Plan> findByUserId(@RequestParam Integer userId) {
        return planService.findByUserId(userId);
    }
}

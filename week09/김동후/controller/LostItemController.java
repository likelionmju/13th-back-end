    package com.example.week08assignment.controller;

    import com.example.week08assignment.domain.LostItem;
    import com.example.week08assignment.service.LostItemService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;
    import java.util.Optional;

    @RestController
    @RequestMapping("/api/lostItems")
    public class LostItemController {

        private final LostItemService service;

        @Autowired
        public LostItemController(LostItemService service) {
            this.service = service;
        }

        @PostMapping
        public LostItem save(@RequestBody LostItem lostItem) {
            return service.save(lostItem);
        }


        @GetMapping
        public List<LostItem> getAll() {
            return service.findAll();
        }

        @GetMapping("/{id}")
        public Optional<LostItem> getById(@PathVariable Long id) {
            return service.findById(id);
        }

        @GetMapping("/search")
        public List<LostItem> searchByLocation(@RequestParam String location) {
            return service.findByLocation(location);
        }
    }

package com.example.demo.controller;

import com.example.demo.service.ContactService;
import com.example.demo.member.Contact;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contacts")
public class ContactController {
    private final ContactService contactService;

    @PostMapping("/create")
    @Operation(summary = "학생 추가", description = "name, studentNumber, score로 추가")
    public Contact create(@RequestBody Contact contact) {
        return contactService.save(contact);
    }

    @GetMapping("/all")
    public List<Contact> findAll() {
        return contactService.findAll();
    }

    @GetMapping("/studentNumber/{studentNumber}")
    public Contact findById(@PathVariable Long id) {
        return contactService.findById(id);
    }

    @GetMapping("/score/{score}")
    public Contact findByScore(@PathVariable String name) {
        return contactService.findByName(name);
    }

    @PutMapping
    public Contact update(@RequestBody Contact request) {
        return contactService.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        contactService.delete(id);
    }
}

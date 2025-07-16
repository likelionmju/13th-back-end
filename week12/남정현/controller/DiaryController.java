package com.example.diary.controller;


import com.example.diary.dto.DiaryRequest;
import com.example.diary.dto.DiaryResponse;
import com.example.diary.entity.Diary;
import com.example.diary.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.YearMonth;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/diaries")
public class DiaryController {

    private final DiaryService dairyService;

    @PostMapping
    public DiaryResponse createDiary(@RequestBody DiaryRequest request) {
        return dairyService.createDiary(request);
    }

    @GetMapping("/{id}")
    public DiaryResponse getDiaryById(@PathVariable Long id) {
        return dairyService.getDiaryById(id);

    }

    @PutMapping("{id}")
    public DiaryResponse updateDiary(@PathVariable Long id, @RequestBody DiaryRequest request) {
        return dairyService.updateDiary(id, request);
    }


    @DeleteMapping("/{id}")
    public Map<String, String> deleteDiary(@PathVariable Long id) {
        return dairyService.deleteDiary(id);
    }


    @GetMapping("/month")
    public List<DiaryResponse> getDiariesByMonth(@RequestParam("month") YearMonth yearMonth){
        return dairyService.getDiariesByMonth(yearMonth);
    }


}



//@RestController
//@RequestMapping("/contacts")
//@RequiredArgsConstructor
//public class ContactController {
//
//    private final ContactService contactService;
//
//    @PostMapping("/create")
//    public Contact create(@RequestBody Contact contact) {
//        return contactService.save(contact);
//    }
//
//    @GetMapping("/all")
//    public List<Contact> findAll() {
//        return contactService.findAll();
//    }
//
//    @GetMapping("/id/{id}")
//    public Contact findById(@PathVariable Long id) {
//        return contactService.findById(id);
//    }
//
//    @GetMapping("/name/{name}")
//    public Contact findByName(@PathVariable String name) {
//        return contactService.findByName(name);
//    }
//
//    @PutMapping
//    public Contact update(@RequestBody Contact request) {
//        return contactService.update(name, request);
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable Long id) {
//        contactService.delete(id);
//    }
//}

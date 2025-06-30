package com.example.spring_project.grade.controller;


import com.example.spring_project.grade.domain.Grade;
import com.example.spring_project.grade.service.GradeService;
import com.example.spring_project.member.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// @RequiredArgsConstructor
@Controller
@RequestMapping("/grades")
@Tag(name = "Grade Controller", description="주소록 crud. (api,viewer 분리전)")
public class GradeController {
    private final GradeService gradeService;

    @Autowired
    public GradeController(GradeService gradeService, MemberService memberService) {
        this.gradeService = gradeService;
    }
    @GetMapping("/main")
    public String createForm() {
        return "grades/gradeMain";
    }
    @GetMapping("/new")
    public String createNewForm(Model model) {
        return "grades/createGradeForm";
    }
    @PostMapping("/new")
    public String create(Grade grade) {
        gradeService.save(grade);
        return "redirect:/";
    }
    @GetMapping("/list")
    public String creatList(Model model) {
        List<Grade> gradeList = gradeService.findAll();
        model.addAttribute("gradeList", gradeList);
        return "grades/gradeList";
    }
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Grade grade = gradeService.findById(id);
        model.addAttribute("grade", grade);
        return "grades/editGradeForm";
    }
    // viewer 용도
    @PostMapping("/edit/{id}")
    public String update(@PathVariable Long id, Grade grade) {
        gradeService.update(id, grade);
        return "redirect:/grades/list";
    }
    // api용도
    @ResponseBody
    @Operation(summary = "성적 수정")
    @PutMapping("/api/edit/{id}")
    public Grade updateGrade(@PathVariable Long id, @RequestBody Grade request) {
        return gradeService.update(id, request);
    }
    // viewer 용도
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        gradeService.deleteById(id);
        return "redirect:/grades/list";
    }
    // api 용도
    @ResponseBody
    @DeleteMapping("/api/delete/{id}")
    @Operation(summary = "삭제", description = "id 로 삭제")
    public void deleteGrade(@PathVariable Long id) {
        gradeService.deleteById(id);
    }
    @GetMapping("/api/find/name/{name}")
    public Grade findName(@PathVariable String name, Model model) {
        return gradeService.findByName(name);
    }

}

package com.example.practice0505.controller;

import com.example.practice0505.domain.Member;
import com.example.practice0505.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/members/new")
    public String showRegisterForm() {
        return "register";
    }

    @PostMapping("/members")
    public String register(@RequestParam String name, @RequestParam int age) {
        memberService.register(name, age);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        model.addAttribute("members", memberService.getAllMembers());
        return "members";
    }

    @GetMapping("/members/search")
    public String search(@RequestParam String name, Model model) {
        Member member = memberService.findByName(name);
        model.addAttribute("member", member);
        return "member";
    }
}
package com.example.member.controller;

import com.example.member.domain.Member;
import com.example.member.repository.MemoryMemberRepository;
import com.example.member.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService service;

    public MemberController() {
        this.service = new MemberService(new MemoryMemberRepository());
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/members/new")
    public String showRegisterForm() {
        return "register";
    }

    @PostMapping("/members")
    public String register(@RequestParam String name, @RequestParam int age) {
        Member member = new Member(name, age);
        service.register(member);
        return "redirect:/members";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = service.getAllMembers();
        model.addAttribute("members", members);
        return "members";
    }

    @GetMapping("/members/search")
    public String search(@RequestParam String name, Model model) {
        Member member = service.findMember(name);
        model.addAttribute("member", member);
        return "member";
    }
}

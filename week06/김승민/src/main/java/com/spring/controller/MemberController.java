package com.spring.controller;

import com.spring.model.Member;
import com.spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "register";
    }

    @PostMapping("/members")
    public String create(MemberForm form) {
        Member member = new Member(form.getName(), form.getAge());
        memberService.register(member);
        return "redirect:/members";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findAllMembers();
        model.addAttribute("members", members);
        return "members";
    }

    @GetMapping("/members/search")
    public String search(@RequestParam("name") String name, Model model) {
        Member member = memberService.findMemberByName(name);
        if (member != null) {
            model.addAttribute("member", member);
            return "member";
        } else {
            model.addAttribute("errorMessage", "등록된 회원이 아님");
            return "index";
        }
    }
}
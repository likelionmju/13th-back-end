package com.example.hellospring.controller;

import com.example.hellospring.entity.Member;
import com.example.hellospring.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class ViewController {
    MemberService memberService;
    @Autowired
    public ViewController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String newMember() {
        return "register";
    }

    @GetMapping("/members")
    public String viewAllMembers(Model model) {
        List<Member> allMembers = memberService.findAll();
        model.addAttribute("members", allMembers);
        return "members";
    }

    @GetMapping("/members/search")
    public String viewOneMember(@RequestParam("name") String name, Model model) {
        Member member = memberService.findByName(name);
        if(member == null){
            //입력한 이름의 회원이 없다
        }
        model.addAttribute("member", member);
        return "member";
    }

    @PostMapping("/members")
    public String registerNewMember(
            @RequestParam("name") String name,
            @RequestParam("age") int age
    ) {
        Member member = new Member();
        member.setName(name);
        member.setAge(age);
        Member savedMember = memberService.save(member);
        if (savedMember == null) {
            //회원가입 안됨(같은 이름인 회원이 이미 존재)
        }
        return "redirect:/";
    }
}

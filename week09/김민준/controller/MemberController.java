package com.example.spring_project.controller;

import com.example.spring_project.domain.Member;
import com.example.spring_project.repository.MemberRepository;
import com.example.spring_project.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;
 //   private final MemberRepository memberRepository;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
        // this.memberRepository = memberRepository;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm memberForm) {
        Member member = new Member();
        member.setName(memberForm.getName());
        member.setAge(memberForm.getAge());
        member.setEmail(memberForm.getEmail());
        member.setAllergyInfo(memberForm.isAllergyInfo());

        memberService.join(member);
        return "redirect:/";
    }

    @PostMapping("/api/members")
    @ResponseBody
    public Member createMemberApi(@RequestBody Member member) {
        memberService.join(member);
        return member;
    }

    @GetMapping ("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}

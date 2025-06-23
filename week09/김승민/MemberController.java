package com.example.controller;

import com.example.member.Member;
import com.example.service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/members")
public class MemberController {
    private final MemberService service;

    public MemberController(MemberService service) {
        this.service = service;
    }

    @PostMapping
    public Member save(@RequestBody Member member){
        return service.save(member);
    }

    @GetMapping("/memberAll")
    public List<Member> all() {
        return service.findAllMembers();
    }

    @GetMapping("/memberFind")
    public String memberFind(@RequestParam("id") Long id) {
        Member member = service.findMemberById(id);
        if (member != null) {
            return member.getId()+" "+member.getName()+" "+member.getAge();
        }else{
            return "등록된 회원이 아님";
        }
    }
}

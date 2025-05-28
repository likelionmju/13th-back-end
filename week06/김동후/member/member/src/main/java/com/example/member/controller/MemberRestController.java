package com.example.member.controller;

import com.example.member.domain.Member;
import com.example.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //@Controller + @ResponseBody : 반환되는 객체가 자동으로 JSON으로 변환되어 HTTP 응답 본문(body)으로 전송
@RequestMapping("/api")
public class MemberRestController {
    private final MemberService service;
    @Autowired
    public MemberRestController (MemberService service){ // 생성자 주입 방식
        this.service =service;
    }

    @PostMapping("/api/members")
    public Member register(@RequestParam String name, @RequestParam int age) { // requestbody 로 바꾸기
        Member member = new Member(name, age);
        service.register(member);
        return member;
    }

    @GetMapping("/members/search")
    public Member search(@RequestParam String name) {
        Member member = service.findMember(name);
        return member;
    }

    @GetMapping("/api/members")
    public Member getOne() {
        return service.getAllMembers().get(0);
    }





}

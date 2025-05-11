package com.example.week06_hw.controller;

import com.example.week06_hw.domain.Member;
import com.example.week06_hw.repository.MemoryMemberRepository;
import com.example.week06_hw.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {
    //컨트롤러는 직접 데이터를 저장하지 않으므로, 대신 일을 할 수 있는 MemberService에게 넘김
    private final MemberService memberService = new MemberService(new MemoryMemberRepository());

    @GetMapping("/")
    public String home() {
        return "index"; // index.html
    }

    @GetMapping("/members/new")
    public String showRegisterForm() {
        return "register"; // register.html
    }

    @PostMapping("/members")   // RequestParam으로 사용자가 보낸 응답을 받음
    public String registerMember(@RequestParam String name, @RequestParam int age, Model model) {
        Member member = new Member(name, age); //Member 객체 생성하고 값 전달
        try { //중복 회원이 들어오면 예외처리하도록 함
            memberService.register(member);
            return "redirect:/";
        } catch (IllegalStateException e) { //duplicate.html 실행
            if ("duplicate".equals(e.getMessage())) {
                return "duplicate";
            }
        }return "error";
    }

    @GetMapping("/members")
    public String showAll(Model model) {//전체 회원 조회
        //addAttribute: 컨트롤러에서 html로 데이터 보내줌
        model.addAttribute("members", memberService.findAll()); //전체 회원조회이므로 findAll
        return "members"; // members.html
    }

    @GetMapping("/members/search")
    public String search(@RequestParam String name, Model model) {
        Member member = memberService.findOne(name);
        model.addAttribute("member", member);
        return "member"; // member.html
    }
}

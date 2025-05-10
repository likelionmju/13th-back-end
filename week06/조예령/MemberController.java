package likelion.Member.controller;

import likelion.Member.domain.Member;
import likelion.Member.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String registerMember() {
        return "register";
    }

    @PostMapping("/members")
    public String submitMember(@RequestParam String name, @RequestParam int age, Model model){
        Member member = new Member();
        member.setName(name);
        member.setAge(age);
        member.setAdult(age >= 20);
        memberService.registerMember(member);
        model.addAttribute("member", member);
        return "member";
    }

    @GetMapping("/members/search")
    public String searchMember(@RequestParam String name, Model model){
        Member member = memberService.searchMember(name);
        model.addAttribute("member", member);
        return "member";
    }

    @GetMapping("/members")
    public String members(Model model) {
        model.addAttribute("members", memberService.listMember());
        return "members";
    }
}

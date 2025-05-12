package hello.week06.controller;

import hello.week06.model.Member;
import hello.week06.repository.MemoryMemberRepository;
import hello.week06.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    public MemberController() {
        // 수동으로 DI
        this.memberService = new MemberService(new MemoryMemberRepository());
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "register";
    }

    @PostMapping("/members")
    public String register(@RequestParam String name, @RequestParam int age) {
        Member member = new Member(name, age);
        memberService.register(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findAll();
        model.addAttribute("members", members);
        return "members";
    }

    @GetMapping("/members/search")
    public String search(@RequestParam String name, Model model) {
        Member member = memberService.findByName(name);
        if (member == null) {
            return "redirect:/"; // or error page
        }
        model.addAttribute("member", member);
        return "member";
    }
}

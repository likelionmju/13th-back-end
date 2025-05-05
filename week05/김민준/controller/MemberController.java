package hello.hello_spring.controller;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
// 아래와 같이 import를 바꿔주세요!
import org.springframework.ui.Model;
import java.util.List;


// “스프링이 생성하고 관리하는 객체”**를 **빈(Bean) 이라고 함
// 스프링이 대신 만들어서 관리하게 맡기는 객체 = Bean
@Controller // @Controller는 이 클래스가 사용자 요청을 처리하는 역할
public class MemberController {
    private final MemberService memberService;
    private final MemberRepository memberRepository;

    // 개발자가 new MemberService() 하지 않아도 스프링이 자동으로 빈을 찾아서 넣어줌.
    @Autowired // 자동주입: 스프링 컨테이너가 알아서 객체(빈)를 찾아서 넣어주는 기능
    public MemberController(MemberService memberService, MemberRepository memberRepository) {
        this.memberService = memberService;
        this.memberRepository = memberRepository;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }
    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }
    @GetMapping ("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }


}

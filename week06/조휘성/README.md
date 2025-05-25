week06 과 제 란

### MVC
MemberController를 통해 사용자의 요청을 받아들이고 MemberService를 통해 사용자가 원하는 객체 생성, 객체 모두 조회 그리고 객체 한개 조회 등의 기능을 제공하였습니다. 또한 이렇게 제공되는 기능은 HTML파일을 통해 화면으로 보여지도록 하였습니다.

### DI / IOC
Controller와 Service를 제작할 때 의존성 주입(Dependency Injection)을 


<!-- public class MemberController {
    private final MemberService memberService;
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}

public class MemberService {
    private final MemberRepository memberRepository;
    
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
} -->

와 같은 방식으로 의존성을 약하게 해주었습니다. 이러한 의존성 주입은 개발자로 하여금 유연하고 확장성이 뛰어난 코드를 작성 할 수 있도록 해줍니다.
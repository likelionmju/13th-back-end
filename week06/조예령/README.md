week06 과 제 란

### MVC
model + view + controller 구조인 MVC 패턴에 맞게
MemberController 클래스에서 사용자 요청을 받고 ->
MemberSevice에서 Member 객체를 생성하거나 조회하는 등 비즈니스 로직을 처리하고 ->
members.html, resiter.html 등에서 화면을 보여주도록 했습니다.

### DI/IoC
확장성이 뛰어난 코드로 만들기 위해 의존성 주입, 그중에서도 생성자 주입 방식을 사용했습니다.
MemberController 클래스 중
```
private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
```
이처럼 클래스의 생성자를 통해 의존성을 주입했습니다.

MemberService 클래스에서도
```
private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
```
같은 방식을 사용했습니다.

week06 과 제 란
## MVC 패턴 
Model: Member, MemberRepository,MemberService
Veiw: 모든 html
Controller: MemberController 

클라이언트 요청 -> MemberController가 요청을 받음->
MemberService에게 전체 회원 요청-> 실제 데이터는 MemberRepository가 전달 -> 이를 받은 Controller가 model.addAttribute로 view 로 넘기고, 사용자의 화면에 뜨게 됨

## DI
-MemberService에서 MemberRepository를 직접 만들지 않고 생성자를 통해 주입
- 의존성 주입을 통한 코드 유연성, 변경이나 테스트 용이 실현 

## Ioc
-IoC(제어의 역전)은 객체 생성을 spring이 대신 해주는 것... 
-따라서, 이번 과제에서는 new 를 사용하지 않았음
-에를 들어, MemberService에서는
private final MemberRepository memberRepository 선언만 하고 객체는 만들지 않았음 

week06 과 제 란

1. MVC 적용
    1. Model
        com.spring.model.Member 클래스 
        회원 데이터 담기

    2. View
        main/resources/templates 폴더 내 html 파일들.
        사용자 화면 구성

    3. Controller
        com.spring.controller.MemberController 클래스 
        /members/new에서 회원 등록 폼 register.html 보여줌
        /members에서 MemberService를 통해 회원목록 조회해서 Model에 담고 members.html에 전달
        /members/search에서 회원 조회해서 Model에 담고 member.html에 전달


2. DI
    @Autowired 어노테이션으로 의존성 객체를 스프링 컨테이너로부터 주입 받음.
    MemberController는 MemberService에 의존
    MemberService는 MemberRepository에 의존

3. IoC
    @Controller, @Service, @Repository 어노테이션을 사용해서 해당 클래스를 스프링 빈으로 등록 -> 스프링 컨테이너가 객체 생성, 관리
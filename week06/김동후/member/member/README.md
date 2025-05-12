# 1. MVC 패턴
**Model**: `Member.java` 클래스 – 회원 정보를 표현하는 도메인 객체
**View**: `index.html`, `register.html`, `members.html`, `member.html` – Thymeleaf 템플릿으로 사용자 화면 렌더링
**Controller**: `MemberController.java` – URL 요청을 받아 서비스 로직 실행 후 결과를 뷰로 전달

# 2. DI
`MemberService`는 `MemberRepository`를 생성자로 주입받아 사용
`@Service`, `@Repository` 통해 자동 주입

# 3. IoC
객체 생성을 스프링이 대신 제어



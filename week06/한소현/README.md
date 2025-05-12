week06 과 제 란
#MVC

## Controller
/members/new > register.html
/members > Memberservice 통해 회원 목록 > members.html
/members/search > 한명 회원 조회 > member.html

## View
static, tmeplates > html

## Model
Member class < 회원 데이터

#DI
@Autowired 통해 의존성 객체 스프링 컨테이너가 주입
MemberController > MemberService
MemberService < MemberRepository


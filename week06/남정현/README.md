### MVC
## Controller 
MemberController : 사용자의 요청을 받아서 처리 
                    HTML에서 입력받은 데이터  
                    -> MeberService 전달
                    -> 결과 모델에 담아서 View로 반환

## Model 
Model : 회원 데이터를 담는 클래스
MemberRepository : 회원 정보를 저장하거나 불러오기 위한 저장소
MemoryMemberRepository : MemberRepository를 구현한 클래스, 실제 회원 데이터를 메모리(Map)에 저장하는 구현체

## View
html파일 : 사용자가 보는 화면, Controller에서 전달한 데이터를 Thymeleaf 문법을 통해 보여줌

Service는 데이터를 어떻게 처리할지 로직을 작성하는 부분 MVC는 아니지만 꼭 사용함
비즈니스 로직을 깔끔하게 분리하기 위함.


### DI/IoC
## IoC
내가 직접 new객체() 하지않고, Spring이 대신 객체를 만들어서 관리해주는 것
@Service, @Controller, @Repository 어노테이션을 붙이면 Spring IoC컨테이너가 해당 객체를 자동 생성/관리


## DI
필요한 객체를 Spring이 자동 주입해주는 것

MemberController는 MeberService를 써야함
private final MemberService memberService;
하지만 @Autowired또는 @RequiredArgsConstructor를 사용하면
직접 생성하지 않아도 됨, 자동으로 MemberService 주입
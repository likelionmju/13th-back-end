week06 과 제 란

## MVC활용
HTML이 뷰의 역할로 화면을 구성하고 이 뷰에 어떤 내용이 올지 조절하는 역할을 구현하기 위해 모델, 컨트롤러, 서비스, 레포지터리 패키지를 만들었다. 모델이 데이터를 가지고 있고 컨트롤러에서 getMapping으로 모델의 데이터를 얻는다.

## DI
MemberService에서 MemberRepository인터페이스의 매서드들을 구현하는 부분에서 의존성이 나타남

## IoC
@Repository, @Controller 등 어노테이션으로 등록된 클래스는 Spring IoC 컨테이너가 관리하여 우리가 직접 객체를 new하지 않아도 됨
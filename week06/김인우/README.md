# MVC

## View
Controller가 넘긴 데이터 수신 -> thymeleaf
Controller에 요청 -> <form> 태그

## Controller
URL 요청(GET/POST)을 매핑(@GetMapping)
-> Model에 데이터를 담아(model.addAttribute())
-> View 리턴 (return "주소")

## Model
도메인 객체 : Member Class
비즈니스 로직 처리(회원 관리, 중복 검사) -> Service Class


# DI/IOC

## 순서 
스프링 컨테이너 등록(IOC) -> 의존 관계 주입(DI)

## 스프링 컨테이너 등록 
@Controller, @Service, @Repository -> 공통된 @Component를 통해 스프링 컨테이너에 등록

## 의존 관계 주입
주입 방식 : 생성자 주입

Controller는 Service에,
Service는 Repository에 의존

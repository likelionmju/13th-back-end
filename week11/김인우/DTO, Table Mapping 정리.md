# DTO
계층 간 데이터 교환을 위한 객체  
사용 이유 : 클라이언트와 소통하는 객체와 DB와 소통하는 객체를 구분하기 위해서   
-> Entity는 DB 관련 책임, DTO는 유효성 관련 책임으로 구분  
Entity -> DB의 Table과 매핑(DB 관련 정보 담김)  
DTO -> 요청/응답 API와 매핑(유효성 관련 정보 담김)  
DTO 역할 : 유효성 검사를 통해 http 요청이 잘못되었을 때, 오류코드를 5XX가 아닌 4XX 로 반환하게 한다.  

# Table Mapping
## 객체와 테이블의 차이
객체는 필드로 다른 객체 참조  
Table는 FK로 다른 Table 참조   

## 단방향 연관관계
객체의 필드 = 테이블의 컬럼  
필드 중 FK가 존재한다? FK임을 알리는 연관관계 설정 필요  
@ManyToOne, @JoinColumn으로 설정 -> 단방향 연관관계  
예) Post 객체의 User 필드를 통해 Post->User 참조 가능  

## 양방향 연관관계
상황) User(1) : Post(다) -> 일대다 관계  
User가 작성한 Post 목록 조회하기  
  
테이블 : Join을 통해 user_id만으로 Post참조 가능  
-> 양방향 설정 없이도 User->Post 참조 가능  
-> FK 1개로 양방향 연관관계 설정됨  
  
객체 : 양방향 설정 없이는 User->Post 참조 불가  
-> User에 Post 필드 필요 -> 양방향 연관관계  
User, Post 모두 연관관계 설정 시 FK가 2개가 됨  
-> mappedBy 속성으로 FK의 주인 설정  
  
## FetchType
Post 테이블의 컬럼: post_id, 내용, user_id  
Post 객체의 필드 : post_id, 내용, User  
상황) Post 조회하기  
  
테이블에서 Post 조회 -> 문제없음    
객체에서 Post 조회 -> User를 담기 위한 비용이 많이 든다.    
    
해결책 : fetchType 설정    
lazy : Post 조회할 때, User 정보 담지 않음    
-> post.getUser().name() 조회 시 User 관련 쿼리문 실행  
  
eager : Post 조회할 때, Join을 통해 User 정보도 함께 조회  
  
## CascadeType  
상황) User 객체 생성 -> List<Post> post 필드에 Post 2개 추가  
-> user.save() 실시   
결과 : User Table 정보는 담기지만, Post Table은 추가 안됨  
  
해결책: User의 Post필드에 cascadeType 적용  
user.save()가 실행될 때, User의 자식인 Post 쿼리문도 함께 실행  
-> 영속성 콘텍스트와 관련 있음(User와 관련된 영속성 작업 실행 시, 자식인 Post의 영속성 작업도 함께 실행)   
  
장점 : RDB의 참조 무결성 원칙을 지키기 쉽다.  
cascadeType 설정 없이 user.remove() 실행  
->User 테이블의 정보는 삭제되지만  
Post 테이블의 FK중에는 삭제된 user_id가 남아있다. -> 참조 무결성 원칙 위반  

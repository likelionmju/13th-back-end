# 3. 이전 서비스와 어떤 부분에서 달라졌는지
Repository 수동 구현 -> 자동 구현으로 변경
이전에는 Repository 인터페이스를 만들고, 그 구현체를 수동으로 작성해야 했다.
JPA를 도입하면서 JpaRepository를 상속하기만 하면, Spring이 자동으로 구현체를 만들어주기 때문에 직접 구현할 필요가 없어졌다.

메서드 이름 기반 자동 쿼리 생성 
JPA에서는 findByCategory, findById와 같이 메서드 이름만 정의하면
내부적으로 쿼리가 자동 생성되어 DB에서 가져올 데이터 조회가 간단해졌습니다.

데이터 조회 방식의 변화 (PathVariable 사용)
이전에는 조회 방식이 URL 파라미터 기반으로 작성했지만
지금은 @PathVariable을 활용해 /lostitems/{id}와 같은 더 RESTful한 구조로 조회할 수 있게 변경하였습니다.
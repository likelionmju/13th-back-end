## 아기사자
한소현

## 인상 깊었던 부분
### Main Class 코드 간소화
Lotto.drawNumbers()를 Lotto 생성자에서 실행하게 함

### Lotto_I Interface와 상속의 적절한 사용
로또를 뽑는다는 행위(drawNumbers())는 똑같으나, 방식(자동/수동)의 차이가 있다는 점을 잘 활용한 것 같다.
사용자의 자동/수동 입력에 따라, Lotto_I Class의 구현체가 쉽게 바뀌는 게 가능하다. 
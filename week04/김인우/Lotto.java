import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class Lotto {
    private int[] lottoNums;

    public int[] getLottoNums() {
        return lottoNums;
    }

    public Lotto(int size) {
        this.lottoNums = new int[size];
    }

    public void autoSet() {//자동으로 번호 설정
        //lottoNums array의 길이만큼의 번호 추첨 -> lottoNums 배열에 저장 후 return
        Set<Integer> duplicate_check = new HashSet<>(); //중복 검사를 위한 자료구조
        for(int i=0; i<lottoNums.length; i++) {
            int number_drawn = (int)(Math.random()*45)+1;
            if(!duplicate_check.add(number_drawn)) {//중복 검사
                i--;    continue;
            }
            //중복 검사 통과
            lottoNums[i]=number_drawn;
        }
    }

    public void manualSet(Scanner scanner) {
        Set<Integer> duplicate_check = new HashSet<>();
        int count = 1;//for문의 i와 같은 역할 -> 배열크기보다 커지면 while문 종료
        System.out.printf("%d번 숫자를 입력하세요. : ",count);
        while(true) {
            try {
                int number = scanner.nextInt();
                scanner.nextLine();
                if(number<1||number>45) {//1-45의 정수인지 체크
                    System.out.printf("1~45사이의 숫자를 입력해주세요. : ");
                    continue;
                }
                if(!duplicate_check.add(number)) {//숫자 중복 체크
                    System.out.printf("숫자가 중복되었습니다. 다른 숫자를 뽑아주세요. : ");
                    continue;
                }
                //유효성 검사 통과
                lottoNums[count-1]=number;
                System.out.println(count+"번 숫자가 입력되었습니다.");
                count++;
                if(count> lottoNums.length)    return;//반복문 종료 조건
                System.out.printf("%d번 숫자를 입력하세요. : ",count);

            } catch (InputMismatchException e){//숫자가 아닐 때
                scanner.nextLine();
                System.out.printf("숫자를 입력해주세요. : ");
            }
        }
    }
}

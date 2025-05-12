package week04;
import java.util.Scanner;

public class ManualPlayer extends AutoPlayer {
    Scanner scan = new Scanner(System.in);

    @Override
    public int[] getNumber() {
        System.out.println("1~45사이의 숫자 6개를 입력하세요");
        int count = 0;
        while (count < 6) {
            int temp = scan.nextInt();
            if (temp >= 1 && temp <= 45) {
                numbers[count] = temp;
                count++;
            }
            else {
                System.out.println("잘못된 입력값입니다. 다시 입력해주세요");
            }
        }
        return numbers;
    }

}

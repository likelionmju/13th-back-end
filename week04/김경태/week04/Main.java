package week04;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] playerNumbers;
        System.out.println("로또 추첨방식 : 자동, 수동");

        while (true) {
            String answer = scan.nextLine();
            if (Objects.equals(answer, "자동")) {
                AutoPlayer p = new AutoPlayer();
                playerNumbers = p.getNumber();
                System.out.println("자동 추첨 번호는");
                p.printNumbers();
                System.out.println();
                break;
            }
            else if (Objects.equals(answer, "수동")) {
                ManualPlayer p = new ManualPlayer();
                playerNumbers = p.getNumber();
                break;
            }
            else {
                System.out.println("잘못된 입력값입니다 다시 입력해주세요");
            }
        }
        LottoMachine lottoMachine = new LottoMachine();

//      로또 당첨번호, 보너스번호
        int[] lottoResult = lottoMachine.getNumber();
        int bonusNumber = lottoMachine.bonusNumber();

//      로또 당첨번호, 보너스번호 출력
        System.out.println("당첨번호는 ...");
        lottoMachine.printNumbers();
        System.out.print(" + " + bonusNumber);
        System.out.println();

//      결과 출력
        LottoChecker lottoChecker = new LottoChecker();
        String result = lottoChecker.checkResult(lottoResult, playerNumbers, bonusNumber);
        System.out.println("결과는 " + result + "입니다." );
        scan.close();
    }
}

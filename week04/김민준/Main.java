import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player = null;
        // player 는 interface
        System.out.println("로또 구매 방식: 자동, 수동");
        while (true) {
            String answer = scanner.nextLine();
            if (Objects.equals(answer, "자동")) {
                player = new AutoPlayer();
                break;
            } else if (Objects.equals(answer, "수동")) {
                player = new ManualPlayer();
                break;
            } else {
                System.out.println("잘못된 입력");
            }
        }

        player.printNumbers();

        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.generateNumbers();

        // locker checker에 인자 넘겨 비교
        LottoChecker lottoChecker = new LottoChecker();
        String result = lottoChecker.checkResult(
                lottoMachine.getWinningNumbers(),
                player.getNumbers(),
                lottoMachine.getBonusNumber());
        // 최종결과출력
        System.out.println("결과는 " + result + "입니다.");
        scanner.close();
    }
}
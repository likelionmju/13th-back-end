import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();
        LottoChecker lottoChecker = new LottoChecker();
        lottoMachine.drawNumbers();

        System.out.println("로또 방식을 입력하세요 (자동/수동):");

        Scanner scanner = new Scanner(System.in);
        String method = scanner.next();

        Player player;

        if (method.equals("자동")) {
            System.out.println("자동 방식을 사용합니다.");
            player = new AutoPlayer();
        }
        else if (method.equals("수동")) {
            System.out.println("수동 방식을 사용합니다.");
            player = new ManualPlayer();
        }
        else {
            System.out.println("방식을 정확하게 설정하지 않았습니다. 자동 방식을 사용합니다.");
            player = new AutoPlayer();
        }

        player.inputNumbers();


        int[] winningNumbers = lottoMachine.getWinningNumbers();
        int[] playerNumbers = player.getPlayerNumbers();

        System.out.println("플레이어 번호:");
        for (int i = 0; i < 6; i++) {
            System.out.print(playerNumbers[i] + " ");
        }

        System.out.println();

        System.out.println("당첨 번호:");
        for (int i = 0; i < 7; i++) {
            System.out.print(winningNumbers[i] + " ");
        }

        String result = lottoChecker.checkResult(winningNumbers, playerNumbers);
        System.out.println("결과: " + result);
    }
}
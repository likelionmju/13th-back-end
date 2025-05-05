import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LottoMachine lottoMachine = new LottoMachine(scanner);
        lottoMachine.createWinningNumbers();
        lottoMachine.createBonusNumber();

        Player player = new Player(scanner);
        player.inputPlayerNumbers();

        int[] winningNumbers = lottoMachine.getWinningNumbers();
        int bonusNumber = lottoMachine.getBonusNumber();
        int[] playerNumbers = player.getPlayerNumbers();

        LottoChecker lottoChecker = new LottoChecker();
        String result = lottoChecker.checkResult(winningNumbers, bonusNumber, playerNumbers);

        System.out.println();
        System.out.println("===== 결과 =====");
        System.out.println("당첨 번호: " + Arrays.toString(winningNumbers));
        System.out.println("보너스 번호: " + bonusNumber);
        System.out.println("내 번호: " + Arrays.toString(playerNumbers));
        System.out.println("당첨 결과: " + result);
    }
}

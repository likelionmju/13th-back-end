import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.drawNumbers(scanner);

        Player player = new Player();
        player.inputNumbers(scanner);

        int[] winningNumbers = lottoMachine.getWinningNumbers();
        int[] playerNumbers = player.getPlayerNumbers();

        LottoChecker lottoChecker = new LottoChecker();
        String result = lottoChecker.checkResult(winningNumbers, playerNumbers);

        System.out.println();
        System.out.println("결과: " + result);
    }
}

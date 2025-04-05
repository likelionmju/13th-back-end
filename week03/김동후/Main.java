import java.util.Scanner;
import java.util.Arrays;

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

class LottoMachine {
    private int[] winningNumbers = new int[6];

    public void drawNumbers(Scanner scanner) {
        for (int i = 0; i < 6; i++) {
            winningNumbers[i] = scanner.nextInt();
        }
        Arrays.sort(winningNumbers);
    }

    public int[] getWinningNumbers() {
        return winningNumbers;
    }
}

class Player {
    private int[] playerNumbers = new int[6];

    public void inputNumbers(Scanner scanner) {
        for (int i = 0; i < 6; i++) {
            playerNumbers[i] = scanner.nextInt();
        }
        Arrays.sort(playerNumbers);
    }

    public int[] getPlayerNumbers() {
        return playerNumbers;
    }
}

class LottoChecker {
    public String checkResult(int[] winningNumbers, int[] playerNumbers) {
        int matchCount = 0;
        for (int wn : winningNumbers) {
            for (int pn : playerNumbers) {
                if (wn == pn) matchCount++;
            }
        }

        switch (matchCount) {
            case 5: return "1등";
            case 4: return "2등";
            case 3: return "3등";
            default: return "꽝";
        }
    }
}

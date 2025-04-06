import java.util.*;

public class Main {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.drawNumbers();

        Player player = new Player();
        player.inputNumbers();

        int[] winningNumbers = lottoMachine.getWinningNumbers();
        int[] playerNumbers = player.getPlayerNumbers();

        LottoChecker lottoChecker = new LottoChecker();
        String result = lottoChecker.checkResult(winningNumbers, playerNumbers);
        System.out.println("결과: " + result);
    }
    static class LottoMachine {
        private int[] winningNumbers = new int[6];

        public void drawNumbers() {
            Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < 6; i++) {
                winningNumbers[i] = scanner.nextInt();
            }
        }

        public int[] getWinningNumbers() {
            return winningNumbers;
        }
    }
    static class Player {
        private int[] playerNumbers = new int[6];
        public void inputNumbers() {
            Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < 6; i++) {
                playerNumbers[i] = scanner.nextInt();
            }
        }
        public int[] getPlayerNumbers() {
            return playerNumbers;
        }
    }

    static class LottoChecker {
        public String checkResult(int[] winning, int[] player) {
            int count = 0;
            for (int num : player) {
                for (int win : winning) {
                    if (num == win) count++;
                }
            }
            return switch (count) {
                case 6 -> "1등";
                case 5 -> "2등";
                case 4 -> "3등";
                default -> "꽝";
            };
        }
    }
}
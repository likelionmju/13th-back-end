import java.util.Scanner;

public class LottoMachine {
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
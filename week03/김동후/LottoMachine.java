import java.util.Scanner;
import java.util.Arrays;

public class LottoMachine {
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

import java.util.Scanner;

public class LottoMachine {
    Scanner scanner = new Scanner(System.in);
    int[] numbers = new int[6];

    public void drawNumbers() {
        for(int i = 0; i < 6; i++) {
              numbers[i] = scanner.nextInt();
        }
    }

    public int[] getWinningNumbers() {
        return numbers;
    }
}

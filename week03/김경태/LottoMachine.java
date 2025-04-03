package week03;
import java.util.Scanner;

public class LottoMachine {
    Scanner scanner = new Scanner(System.in);
    int [] number = new int[6];
    public int[] drawNumbers() {
        for (int i = 0; i < 6; i++) {
            number[i] = scanner.nextInt();
        }
        return number;
    }
    public int [] getWinningNumbers() {
        return number;
    }
}

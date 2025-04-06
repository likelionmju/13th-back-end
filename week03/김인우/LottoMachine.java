import java.util.Scanner;

public class LottoMachine {
    private int[] numbers;

    public LottoMachine() {
        this.numbers = new int[6];
    }

    public void drawNumbers(Scanner scanner) {
        for(int i=0; i<numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }
    }

    public int[] getWinningNumbers() {
        return numbers;
    }
}

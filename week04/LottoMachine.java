package week04;

import java.util.Random;

public class LottoMachine {
    Random rand = new Random();
    int numbers[] = new int[7];

    public void drawNumbers() {
        for (int i = 0; i < numbers.length; i++) {
            int randNumber = rand.nextInt(45) + 1;
            if (numberChecker(randNumber, i)) {
                numbers[i] = randNumber;
                i++;
            }
        }

    }

    boolean numberChecker(int n, int i) {
        for (int k = 0; k < numbers.length; k++) {
            if (numbers[k] == n) {
                return false;
            }
        }
        return true;
    }

    public int[] getWinningNumbers() {
        return numbers;
    }
}

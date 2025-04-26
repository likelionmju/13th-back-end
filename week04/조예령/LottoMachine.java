import java.util.Random;

public class LottoMachine {
    public int[] numbers = new int[7];
    public Random random = new Random();

    public void drawNumbers() {
        int i = 0;
        while(i < 7) {
            int randomNum = random.nextInt(45) + 1;
            if (checkUnique(randomNum, numbers)) {
                numbers[i] = randomNum;
                i++;
            }
        }
    }

    public boolean checkUnique(int num, int[] numbers) {
        for (int n : numbers) {
            if (n != 0 && n == num) {
                return false;
            }
        }
        return true;
    }

    public int[] getWinningNumbers() {
        return numbers;
    }
}

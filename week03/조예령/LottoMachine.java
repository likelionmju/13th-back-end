import java.util.Random;

public class LottoMachine {
    static int[] numbers = new int[6];
    static Random random = new Random();

    public static void drawNumbers() {

        for(int i=0; i < 6; i++) {
            numbers[i] = random.nextInt(45) + 1;
        }
    }

    public static int[] getWinningNumbers() {
        return numbers;
    }
}

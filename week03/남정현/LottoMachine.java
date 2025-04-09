package mutsa.week03_practice;
import java.util.Scanner;
public class LottoMachine {
    private int[] winningNumber = new int[6];
    Scanner scn = new Scanner(System.in);
    public void drawNumbers() {
        for (int i = 0; i <= 5; i++) {
            winningNumber[i] = scn.nextInt();

        }

    }

    public int[] getWinningNumbers() {
        return winningNumber;


    }

}

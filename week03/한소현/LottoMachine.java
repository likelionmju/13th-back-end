package Week3;

import java.util.Scanner;

public class LottoMachine {
    private int[] WinningNumbers = new int[6];

    public void drowNumbers(){
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < WinningNumbers.length; i++){
            WinningNumbers[i] = s.nextInt();
        }
    }

    public int[] getWinningNumbers() {
        return WinningNumbers;
    }
}

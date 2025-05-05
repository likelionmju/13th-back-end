package week04;

import java.util.Arrays;

public class LottoChecker {
    public static String checkResult(int[] winningNumbers, int[] playerNumbers) {
        String result;
        int count = 0;
        boolean bonusMatch = false;
        Arrays.sort(playerNumbers);
        Arrays.sort(winningNumbers);

        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 6; j++) {
                if(winningNumbers[i] == playerNumbers[j]) {
                    count++;
                }
            }
        }

        if (winningNumbers[0] == playerNumbers[0]) {
            bonusMatch = true;
        }

        if(count == 6) {
            result = "1등";
        }
        else if(count == 5 && bonusMatch) {
            result = "2등";
        }
        else if(count == 5) {
            result = "3등";
        }
        else if(count == 4) {
            result = "4등";
        }
        else if(count == 3) {
            result = "5등";
        }
        else {
            result = "꽝";
        }
        return result;
    }
}

package week03;

public class LottoChecker {
    public String checkResult(int[] winN, int[] playerN) {
        int Count = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (winN[i] == playerN[j]) {
                    Count += 1;
                }
            }
        }
        if (Count >= 5) {
            return "1등";
        }
        else if (Count >= 4) {
            return "2등";
        }
        else if (Count >= 3) {
            return "3등";
        }
        else {
            return "꽝";
        }
    }
}

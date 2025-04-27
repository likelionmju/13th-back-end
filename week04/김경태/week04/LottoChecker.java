package week04;

public class LottoChecker {
    public String checkResult(int[] winN, int[] playerN, int bonusN) {
        int Count = 0;
        int bonusCount = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (winN[i] == playerN[j]) {
                    Count += 1;
                }
                else if(playerN[i] == bonusN) {
                    bonusCount += 1;
                }
            }
        }
        if (Count >= 6) {
            return "1등";
        }
        else if (Count >= 5 && bonusCount >= 1) {
            return "2등";
        }
        else if (Count >= 5) {
            return "3등";
        }
        else if (Count >= 4) {
            return "4등";
        }
        else if (Count >= 3) {
            return "5등";
        }
        return "꽝";
    }
}

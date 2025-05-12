import java.util.Arrays;

public class LottoChecker {
    public String checkResult(int[] winningNumbers, int bonusNumber, int[] playerNumbers) {
        int matchCount = 0;
        boolean bonusMatch = false;

        for (int num : playerNumbers) {
            if (Arrays.binarySearch(winningNumbers, num) >= 0) {
                matchCount++;
            }
            if (num == bonusNumber) {
                bonusMatch = true;
            }
        }

        return switch (matchCount) {
            case 6 -> "1등!!!";
            case 5 -> bonusMatch ? "2등" : "3등";
            case 4 -> "4등";
            case 3 -> "5등";
            default -> "꽝";
        };
    }
}
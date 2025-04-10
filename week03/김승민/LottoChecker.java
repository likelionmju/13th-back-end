import java.util.Arrays;

public class LottoChecker {
    public String checkResult(int[] winningNumbers, int[] playerNumbers) {
        int matchCount = 0;
        for (int num : playerNumbers) {
            if (Arrays.binarySearch(winningNumbers, num) >= 0) {
                matchCount++;
            }
        }
        return switch (matchCount) {
            case 5 -> "1등";
            case 4 -> "2등";
            case 3 -> "3등";
            default -> "꽝";
        };
    }
}
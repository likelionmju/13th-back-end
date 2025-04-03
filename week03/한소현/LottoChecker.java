package Week3;

public class LottoChecker {
    public String checkResult(int[] num1, int[] num2){
        int count = 0;
        for (int j : num1) {
            for (int k : num2) {
                if (j == k) {
                    count++;
                    break;
                }
            }
        }

        return switch (count) {
            case 5, 6 -> "1등";
            case 4 -> "2등";
            case 3 -> "3등";
            default -> "꽝";
        };
    }
}

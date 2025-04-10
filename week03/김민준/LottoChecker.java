public class LottoChecker {
    public String checkResult(int[] winning, int[] player) {
        int count = 0;
        for (int num : player) {
            for (int win : winning) {
                if (num == win) count++;
            }
        }
        return switch (count) {
            case 6 -> "1등";
            case 5 -> "2등";
            case 4 -> "3등";
            default -> "꽝";
        };
    }
}
public class LottoChecker {
    public static String checkResult(int[] winningNumbers, int[] playerNumbers) {
        String result;
        int count = 0;

        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 6; j++) {
                if(winningNumbers[i] == playerNumbers[j]) {
                    count++;
                }
            }
        }

        if(count >= 5) {
            result = "1등";
        }
        else if(count >= 4) {
            result = "2등";
        }
        else if(count >= 3) {
            result = "3등";
        }
        else {
            result = "꽝";
        }
        return result;
    }
}

public class LottoChecker {
    public String checkResult(int[] winningNumbers, int[] playerNumbers) {
        int matchCount = 0;
        for (int wn : winningNumbers) {
            for (int pn : playerNumbers) {
                if (wn == pn) matchCount++;
            }
        }

        // if - else - return
        switch (matchCount) {
            case 5: return "1등";
            case 4: return "2등";
            case 3: return "3등";
            default: return "꽝";
        }
    }
}



brake
fillEnergy
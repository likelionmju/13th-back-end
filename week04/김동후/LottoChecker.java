public class LottoChecker {
    public String checkResult(int[] winningNumbers, int bonusNumber, int[] playerNumbers) {
        int matchCount = 0;
        boolean bonusMatch = false;

        for (int pn : playerNumbers) {
            for (int wn : winningNumbers) {
                if (pn == wn) matchCount++;
            }
            if (pn == bonusNumber) bonusMatch = true;
        }

        if (matchCount == 6) return "1등";
        if (matchCount == 5 && bonusMatch) return "2등";
        if (matchCount == 5) return "3등";
        if (matchCount == 4) return "4등";
        if (matchCount == 3) return "5등";
        return "꽝";
    }
}

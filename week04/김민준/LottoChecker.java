public class LottoChecker {
    public String checkResult(int[] winN, int[] playerN, int bonusN) {
        int count = 0;
        boolean bonusBool = false; // 보너스번호 체크용 디폴트값은 false

        // 번호 6개 비교 (플레이어 번호 vs 당첨 번호)
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (playerN[i] == winN[j]) {
                    count++;
                }
            }
            if (playerN[i] == bonusN) {
                bonusBool = true; // 보너스 번호 맞았을 때
            }
        }

        if (count == 6) {
            return "1등";
        } else if (count == 5 && bonusBool) {
            return "2등";
        } else if (count == 5) {
            return "3등";
        } else if (count == 4) {
            return "4등";
        } else if (count == 3) {
            return "5등";
        }
        return "꽝";
    }
}
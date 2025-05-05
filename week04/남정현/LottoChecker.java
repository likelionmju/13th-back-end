package mutsa.week03_practice;
import java.util.Set;
public class LottoChecker {
    public String checkResult(Set<Integer> winning_n, Set<Integer> player_n, int bonusNumber, int playerBonus) {
        Set<Integer> temp = new java.util.HashSet<>(winning_n);
        temp.retainAll(player_n);

        int matchCount = temp.size();
        boolean bonusMatch = (bonusNumber == playerBonus);

        String result;

        switch (matchCount) {
            case 6:
                result = "🎉 1등입니다!";
                break;
            case 5:
                if (bonusMatch) {
                    result = "🎉 2등입니다! (보너스 번호 포함)";
                } else {
                    result = "🎉 3등입니다!";
                }
                break;
            case 4:
                result = "🎉 4등입니다!";
                break;
            case 3:
                result = "🎉 5등입니다!";
                break;
            default:
                result = "😥 꽝입니다.";
                break;
        }

        return result;
    }


}

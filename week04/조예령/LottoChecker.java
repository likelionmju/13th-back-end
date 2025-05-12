import java.util.Arrays;

public class LottoChecker {

    String result;
    int count = 0;
    boolean bonus = false;
    public String checkResult(int[] winningNumbers, int[] playerNumbers) {
        Arrays.sort(winningNumbers);
        Arrays.sort(playerNumbers);

        for(int i=0; i<6; i++) {

            if(winningNumbers[i] == playerNumbers[i])
                count++;
        }

        if(playerNumbers[6] == winningNumbers[6])
            bonus = true;

        if (count == 6) {
            result = "1등";
        } else if (count == 5 && bonus) {
            result = "2등";
        } else if (count == 5) {
            result = "3등";
        } else if (count == 4) {
            result = "4등";
        } else if (count == 3) {
            result = "5등";
        } else {
            result = "꽝";
        }
        return result;
    }
}

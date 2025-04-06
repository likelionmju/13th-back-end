public class LottoChecker {

    public String checkResult(int[] winningNumbers, int[] playerNumbers) {
        int count=0;
        for(int winNum:winningNumbers) {
            for(int playerNum:playerNumbers) {
                if(winNum==playerNum) {
                    count++;
                    break;
                }
            }
        }
        if(count>=5) {
            return "1등";
        } else if(count==4) {
            return "2등";
        } else if(count==3) {
            return "3등";
        } else {
            return "꽝";
        }
    }
}

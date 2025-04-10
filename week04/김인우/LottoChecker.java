public class LottoChecker {
    //필드 : 비교할 두 개의 lotto + 결과값(N등/꽝)
    private Lotto dealerLotto;
    private Lotto playerLotto;
    private String result;

    public LottoChecker(Lotto dealerLotto, Lotto playerLotto) {
        this.dealerLotto = dealerLotto;
        this.playerLotto = playerLotto;
    }

    public void checkResult() {
        checkResult(
                dealerLotto.getLottoNums(),playerLotto.getLottoNums()
                );
    }

    public void announceResult() {
        announceResult(
                dealerLotto.getLottoNums(),playerLotto.getLottoNums()
        );
    }

    private void checkResult(int[] dealerArray, int[] playerArray) {
        int count=0;//일치하는 번호의 수
        for(int i = 0; i< dealerArray.length-1; i++) {
            //numCheck(int[],int)->int[]에 int값이 들어있는지 확인(boolean타입)
            if(numCheck(dealerArray[i], playerArray)) {
                count++;
            }
        }
        if(count==6) {
            result = "1등";
        } else if(count==5) {
            if(numCheck(dealerArray[dealerArray.length-1], playerArray)) {
                result ="2등";
            } else {
                result ="3등";
            }
        } else if(count==4) {
            result = "4등";
        } else if(count==3) {
            result = "5등";
        } else {
            result = "꽝";
        }
    }

    private void announceResult(int[] dealerArray, int[] playerArray) {
        //StringBuilder에 결과 내용 저장 후 한 번에 print
        StringBuilder result_statement = new StringBuilder();
        //당첨 번호 출력
        result_statement.append("<당첨결과>\n당첨번호: ");
        for(int i=0;i<6;i++) {
            result_statement.append(dealerArray[i]+" ");
        }
        result_statement.append("+ 보너스: " + dealerArray[dealerArray.length-1]+"\n");
        //사용자의 번호 출력
        result_statement.append("당신의 번호: ");
        for(int num: playerArray) {
            result_statement.append(num+" ");
        }
        //결과 출력
        result_statement.append("\n결과: " + result);
        System.out.println(result_statement);
    }

    private boolean numCheck(int winningNum, int[] playerNumbers) {
        for(int num:playerNumbers) {
            if(winningNum==num)   return true;
        }
        return false;
    }
}
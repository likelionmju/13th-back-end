package mutsa.week03_practice;

public class LottoChecker {


    public String checkResult(int[] winning_n , int[] player_n) {
        int counter = 0;
        for (int num : winning_n) {
            for (int win :player_n) {
                if (num == win) {
                    counter++;
                    break;

                }
            }
        }


        String result_message = "꽝";

        if (counter == 5) {
            result_message = "1등";}
        else if (counter == 4) {
            result_message = "2등";}
        else if (counter == 3) {
            result_message = "3등";
            }

        return result_message ;
    }


}

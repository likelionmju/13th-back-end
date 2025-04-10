package saja03;

public class LottoChecker {

	public String checkResult(int[] winningNumbers, int[] playerNumbers) {
	
		int Count = 0;

		for (int winNum : winningNumbers) {
	        for (int playerNum : playerNumbers) {
	            if (winNum == playerNum) {
	                Count++;
	                break;
	            }
	        }
	    }
		
		if (Count == 5 || Count == 6) {
		    return "1등";
		} else if (Count == 4) {
		    return "2등";
		} else if (Count == 3) {
		    return "3등";
		} else{
		    return "꽝";
		}
	}

}

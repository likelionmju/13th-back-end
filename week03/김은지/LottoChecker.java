
public class LottoChecker {
	public String checkResult(int[] winningNumbers, int[] playerNumbers) {
		int num = 0;
		String result;
		for (int i = 0; i < winningNumbers.length; i++) {
			for (int j = 0; j < winningNumbers.length; j++) {
				if (winningNumbers[i] == playerNumbers[j]) {
					num += 1;
				}

			}
		}
		switch (num) {
		case 5, 6:
			result = "1등";
			break;
		case 4:
			result = "2등";
			break;
		case 3:
			result = "3등";
			break;
		default:
			result = "꽝";
		}

		return result;
	}

}

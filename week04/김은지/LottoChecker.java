class LottoChecker {
	public String checkResult(int[] winningNumbers, int[] playerNumbers, int bonus) {
		int count = 0;
		String result;
		boolean bonusMatch = false;
		// 당첨번호 비교
		for (int i = 0; i < winningNumbers.length; i++) {
			for (int j = 0; j < winningNumbers.length; j++) {
				if (winningNumbers[i] == playerNumbers[j]) {
					count += 1;
				} else if (bonus == playerNumbers[i]) {
					bonusMatch = true;
				}

			}
		}
		// 당첨 등수 판별
		if (count == 6)
			return "1등";
		if (count == 5 && bonusMatch)
			return "2등";
		if (count == 5)
			return "3등";
		if (count == 4)
			return "4등";
		if (count == 3)
			return "5등";
		return "꽝";
	}

}
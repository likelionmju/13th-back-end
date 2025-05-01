package saja03;

public class LottoChecker {

	public void checkResult(int[] winningNumbers, int bonusNumber, int[] playerNumbers) {
		int matchCount = 0;
		boolean bonusMatch = false;

		// 몇 개 맞췄는지 체크
		for (int playerNum : playerNumbers) {
			for (int winNum : winningNumbers) {
				if (playerNum == winNum) {
					matchCount++;
				}
			}
			if (playerNum == bonusNumber) {
				bonusMatch = true;
			}
		}

		// 결과 출력
		if (matchCount == 6) {
			System.out.println("1등");
		} else if (matchCount == 5 && bonusMatch) {
			System.out.println("2등");
		} else if (matchCount == 5) {
			System.out.println("3등");
		} else if (matchCount == 4) {
			System.out.println("4등");
		} else if (matchCount == 3) {
			System.out.println("5등");
		} else {
			System.out.println("꽝입니다.");
		}
	}
}


import java.util.*;

class LottoMachine {
	// 6개 로또 번호 변수
	Scanner scn = new Scanner(System.in);
	private int[] lottoNumber = new int[6]; // 인덱스 6번째 번호가 보너스 번호
	private int bonus;

	void drawNumbers() {
		int i = 0;
		while (i < 6) {
			int n1 = (int) (Math.random() * 45) + 1;
			if (lChecker(n1, i)) {
				lottoNumber[i] = n1;
				i++; //중복이 아닐 때에만 i 추가 
			}
			
		}
		drawBonus();

	}

	boolean lChecker(int n, int i) {
		for (int k = 0; k < i; k++) {
			if (lottoNumber[k] == n) {
				return false; // 중복
			}
		}
		return true;
	}

	void drawBonus() {
		// 보너스번호뽑기
		while (true) {
			int n2 = (int) (Math.random() * 45) + 1;
			boolean found = false;
			for (int k = 0; k < 6; k++) {
				if (lottoNumber[k] == n2) {
					found = true;
				}

			}
			if (!found) {
				bonus = n2;
				break;
			}
		}
	}

	int[] getWinningNumbers() {
		return lottoNumber;
	}

	int getbonus() {
		return bonus;
	}

}
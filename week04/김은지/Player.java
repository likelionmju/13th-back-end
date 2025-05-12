import java.util.*;

class Player {
	Scanner scn = new Scanner(System.in); // 사용자가 입력
	private int[] playerNumbers = new int[6];

	void pSelect(String s) {// 사용자의 선택에 따라
		while (true) {
			if (s.equals("수동")) {
				inputNumbers();
				break;

			} else if (s.equals("자동")) {
				randomInput();
				break;
			} else {
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
				System.out.print("자동/수동: ");
				s = scn.next();

			}
		}

	}

	void randomInput() { // 1~45의 수, 랜덤으로 6개
		int i = 0;
		while (i < 6) {
			int number = (int) (Math.random() * 45) + 1;
			// true면 추가, 아니면 다시 입력받도록 함

			if (!pChecker(number, i)) { // 없다면 추가
				this.playerNumbers[i] = number;
				i += 1;
			}

		}
	}

	boolean pChecker(int number, int i) { // 숫자를 받아서 검사-> 맞으면 그 숫자를 리턴
		boolean found = false;
		for (int k = 0; k < i; k++) {
			if (number == this.playerNumbers[k]) { // 겹치는게 있다면
				found = true;
				return true;
			}
		}
		return false; // 겹치는 것 없음
	}

	void inputNumbers() {// 수동 입력
		int i = 0;
		while (i < 6) {
			try {
				System.out.println((i + 1) + "번째 숫자: ");
				int number = scn.nextInt();
				if (number < 1 || number > 45) {
					System.out.println("1부터 45까지의 숫자를 입력");
					continue;
				}
				if (!pChecker(number, i)) { // 없다면 추가
					this.playerNumbers[i] = number;
					i += 1;
				} else {
					System.out.println("중복된 숫자 입력 불가");
				}

			} catch (InputMismatchException e) {
				System.out.println("숫자만 입력해주세요");
				scn.next();
			}
		}
	}

	public int[] getPlayerNumbers() {
		return playerNumbers;
	}

}

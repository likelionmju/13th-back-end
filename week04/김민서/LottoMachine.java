package saja03;

import java.util.Random;
import java.util.HashSet;

public class LottoMachine {
	private int[] machineNums = new int[6];
	private Random random = new Random();

	public void drawNumbers() {
		HashSet<Integer> numberSet = new HashSet<>();

		// 6개 중복 없이 뽑기
		while (numberSet.size() < 6) {
			int num = random.nextInt(45) + 1; // 1~45
			numberSet.add(num);
		}

		int index = 0;
		for (int num : numberSet) {
			machineNums[index++] = num;
		}
	}

	public int[] getWinningNumbers() {
		System.out.print("당첨 번호: ");
		for (int num : machineNums) {
			System.out.print(num + " ");
		}
		System.out.println();
		return machineNums;
	}

	public int drawBonusNumber(int[] winningNumbers) {
		int bonus;
		while (true) {
			bonus = random.nextInt(45) + 1;
			boolean isDuplicate = false;
			for (int num : winningNumbers) {
				if (bonus == num) {
					isDuplicate = true;
					break;
				}
			}
			if (!isDuplicate) break;
		}
		return bonus;
	}
}


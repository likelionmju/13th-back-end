package saja03;

import java.util.Scanner;
import java.util.Random;
import java.util.HashSet;

public class Player {
	private Scanner sc = new Scanner(System.in);
	private Random random = new Random();

	public int[] manualPick() {
		HashSet<Integer> numbers = new HashSet<>();
		System.out.println("6개의 숫자를 입력하세요 (1~45):");

		while (numbers.size() < 6) {
			System.out.print((numbers.size() + 1) + "번째 숫자: ");
			int num = sc.nextInt();

			if (num < 1 || num > 45) {
				System.out.println("1부터 45 사이 숫자를 입력하세요.");
				continue;
			}
			if (numbers.contains(num)) {
				System.out.println("이미 입력한 숫자입니다. 다른 숫자를 입력하세요.");
				continue;
			}
			numbers.add(num);
		}

		int[] playerNumbers = new int[6];
		int index = 0;
		for (int num : numbers) {
			playerNumbers[index++] = num;
		}
		return playerNumbers;
	}

	public int[] autoPick() {
		HashSet<Integer> numbers = new HashSet<>();

		while (numbers.size() < 6) {
			int num = random.nextInt(45) + 1;
			numbers.add(num);
		}

		int[] playerNumbers = new int[6];
		int index = 0;
		for (int num : numbers) {
			playerNumbers[index++] = num;
		}

		System.out.print("자동 선택 번호: ");
		for (int num : playerNumbers) {
			System.out.print(num + " ");
		}
		System.out.println();
		return playerNumbers;
	}
}


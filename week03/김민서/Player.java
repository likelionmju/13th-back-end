package saja03;

import java.util.Scanner;

public class Player {
	
	private String input;

	public void inputNumbers() {
		// 6개의 번호 입력받기
		Scanner sc = new Scanner(System.in);
		System.out.println("0~99사이의 수를 6개 입력하세요!");
        input = sc.nextLine();
		
	}

	public int[] getPlayerNumbers() {
		// 배열에 저장
		int[] get = new int[6];
		String[] parts = input.trim().split(" ");

		for (int i = 0; i < 6; i++) {
			get[i] = Integer.parseInt(parts[i]);
		}
		
		return get;
	}

}

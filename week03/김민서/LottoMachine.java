package saja03;

import java.util.Random;

public class LottoMachine {

	private int[] machineNums = new int[6];
	
	public void drawNumbers() {
		// 6개의 번호 생성
		Random rd = new Random();
		
		for(int i = 0 ; i<6; i++) {
			machineNums[i] = rd.nextInt(99);
			 
		} 
	}

	public int[] getWinningNumbers() {
		// 배열에 저장 & 난수 보여주기
		
		for(int i : machineNums) {
			System.out.print(i+" ");
		} System.out.println();
		return machineNums;
	}

}

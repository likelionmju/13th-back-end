package saja03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LottoMachine lottoMachine = new LottoMachine();
        LottoChecker checker = new LottoChecker();
        Player player = new Player();

        // 사용자 로또 구매
        System.out.println("로또 구매 방식을 선택하세요 (1. 자동, 2. 수동): ");
        int choice = sc.nextInt();
        int[] playerNumbers;

        if (choice == 1) {
            playerNumbers = player.autoPick();
        } else {
            playerNumbers = player.manualPick();
        }

        // 당첨 번호 생성
        lottoMachine.drawNumbers();
        int[] winningNumbers = lottoMachine.getWinningNumbers();

        // 보너스 번호 생성
        int bonusNumber = lottoMachine.drawBonusNumber(winningNumbers);
        System.out.println("보너스 번호: " + bonusNumber);

        // 결과 확인
        checker.checkResult(winningNumbers, bonusNumber, playerNumbers);

        sc.close();
    }
}

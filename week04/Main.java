package week04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();
        LottoChecker lottoChecker = new LottoChecker();
        lottoMachine.drawNumbers();

        System.out.println("로또 진행 방식을 입력하세요.(자동/수동): ");

        Scanner sc = new Scanner(System.in);
        String menu = sc.next();

        Player player;

        if (menu.equals("자동")) {
            System.out.println("자동으로 숫자를 생성합니다.");
            player = new AutoPlayer();
        }
        else if (menu.equals("수동")) {
            System.out.println("수동으로 숫자를 생성합니다.");
            player = new ManualPlayer();
        }
        else {
            System.out.println("올바른 입력이 아닙니다. 자동으로 숫자를 생성합니다.");
            player = new AutoPlayer();
        }

        player.inputNumbers();

        int[] winningNumbers = lottoMachine.getWinningNumbers();
        int[] playerNumbers = player.getPlayerNumbers();

        System.out.println("플레이어 번호는:");
        for (int i = 0; i < 7; i++) {
            System.out.print(playerNumbers[i] + " ");
        }

        System.out.println();

        System.out.println("당첨 번호는:");
        for (int i = 0; i < 7; i++) {
            System.out.print(winningNumbers[i] + " ");
        }
        
        System.out.println();
        
        String result = lottoChecker.checkResult(winningNumbers, playerNumbers);
        System.out.println("결과는: " + result + "입니다.");
    }
}
package week04;

import java.util.Scanner;

public class ManualPlayer extends Player {
    public int[] playerNumbers = new int[7];

    public void inputNumbers() {
        Scanner sc = new Scanner(System.in);
        int i = 0;

        for (i = 0; i < 6; i++) {
            System.out.print((i + 1) + "번째 숫자를 입력하세요.(1 ~ 45): ");
            try {
                String input = sc.nextLine();
                int inputNumber = Integer.parseInt(input);
                if(inputNumber >= 1 && inputNumber <= 45 && numberCheck(inputNumber, playerNumbers)) {
                    playerNumbers[i] = inputNumber;
                    i++;
                }
                else {
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                }
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }

        while(true) {
            String bonus = sc.nextLine();
            int bonusNumber = Integer.parseInt(bonus);
            if (numberCheck(bonusNumber, playerNumbers)) {
                playerNumbers[6] = bonusNumber;
                break;
            }
        }
    }
    public int[] getPlayerNumbers() {
        return playerNumbers;
    }
}

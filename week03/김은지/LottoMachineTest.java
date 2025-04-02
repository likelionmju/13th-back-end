package likelion;

//로또 번호를 뽑는 기계

import java.util.Scanner;

class LottoMachine {
    //6개 로또 번호 변수
    Scanner scn = new Scanner(System.in);
    private int[] lottoNumber = new int[6];

    void drawNumbers() {
        for (int i = 0; i < lottoNumber.length; i++) {
            lottoNumber[i] = scn.nextInt();//로또 번호 생성
        }
    }

    int[] getWinningNumbers() {
        return lottoNumber;
    }


}

//플레이어가 로또 번호 입력
class Player {
    Scanner scn = new Scanner(System.in);
    private int[] playerNumbers = new int[6];

    void inputNumbers() {
        for (int i = 0; i < playerNumbers.length; i++) {
            playerNumbers[i] = scn.nextInt();
        }
    }

    int[] getPlayerNumbers() {
        return playerNumbers;
    }

}

//로또 번호가 맞았는지 확인하는 클래스
class LottoChecker {
    public String checkResult(int[] winningNumbers, int[] playerNumbers) {
        int num = 0;
        String result;
        for (int i = 0; i < winningNumbers.length; i++) {
            for (int j = 0; j < winningNumbers.length; j++) {
                if (winningNumbers[i] == playerNumbers[j]) {
                    num += 1;
                }

            }
        }
        switch (num) {
            case 5,6:
                result = "1등";
                break;
            case 4:
                result = "2등";
                break;
            case 3:
                result = "3등";
                break;
            default:
                result = "꽝";
        }

        return result;
    }

}

public class LottoMachineTest {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.drawNumbers();

        Player player = new Player();
        player.inputNumbers();

        int[] winningNumbers = lottoMachine.getWinningNumbers();
        int[] playerNumbers = player.getPlayerNumbers();

        LottoChecker lottoChecker = new LottoChecker();
        String result = lottoChecker.checkResult(winningNumbers, playerNumbers);
        System.out.println("결과: " + result);

    }
}

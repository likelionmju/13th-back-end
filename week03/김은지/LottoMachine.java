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
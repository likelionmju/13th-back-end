package mutsa.week03_practice;

import java.util.Arrays; //Arrays 메서드

public class Main {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine(); //LottoMachine 클래스 생성
        lottoMachine.drawNumbers(); //drawNumbers(); 메소드

        Player player = new Player(); //Player 클래스
        player.inputNumbers(); //inputNumbers 메소드

        int[] winningNumbers = lottoMachine.getWinningNumbers(); //getWinning Numbers get함수
        int[] playerNumbers = player.getPlayerNumbers(); // getPlayerNumbers get 함수

        LottoChecker lottoChecker = new LottoChecker(); //LottoChecker 클래스
        String result = lottoChecker.checkResult(winningNumbers, playerNumbers); // checkResult 메소드
        System.out.println("결과: " + result);
    }
}
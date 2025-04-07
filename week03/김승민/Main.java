import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();//LottoMachine 객체 생성
        lottoMachine.inputWinningNumbers();

        Player player = new Player();//Player 객체 생성
        player.inputNumbers();

        int[] winningNumbers = lottoMachine.getWinningNumbers();
        int[] playerNumbers = player.getPlayerNumbers();

        LottoChecker lottoChecker = new LottoChecker();//LottoChecker 객체 생성
        String result = lottoChecker.checkResult(winningNumbers, playerNumbers);
        System.out.println("결과: " + result);
    }
}
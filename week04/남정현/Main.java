package mutsa.week03_practice;
import java.util.Set;
public class Main {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine(); //LottoMachine 클래스 생성
        lottoMachine.drawNumbers(); //drawNumbers(); 메소드

        Player player = new Player(); //Player 클래스
        player.inputNumbers(); //inputNumbers 메소드

        Set<Integer> winningNumbers = lottoMachine.getWinningNumbers(); //getWinning Numbers get함수
        Set<Integer> playerNumbers = player.getPlayerNumbers(); // getPlayerNumbers get 함수

        int lottoBonusNumber = lottoMachine.getBonusNumber();
        int playerBonusNumber = player.getPlayerBonusNumber();

        LottoChecker lottoChecker = new LottoChecker(); //LottoChecker 클래스
        String result = lottoChecker.checkResult(winningNumbers, playerNumbers, lottoBonusNumber,playerBonusNumber );

        System.out.println("===============");
        System.out.println("내 번호: " + playerNumbers + " + 보너스 번호 (" + playerBonusNumber + ")");
        System.out.println("당첨 번호: " + winningNumbers + " + 보너스 번호 (" + lottoBonusNumber + ")");
        System.out.println("===============");

        System.out.println("결과: " + result);
    }
}
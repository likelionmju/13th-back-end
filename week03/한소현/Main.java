package Week3;

public class Main {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.drowNumbers();

        Player player = new Player();
        player.inputNumbers();

        int[] winningNumbers = lottoMachine.getWinningNumbers();
        int[] playerNumbers = player.getPlayerNumbers();

        LottoChecker lottoChecker = new LottoChecker();
        String result = lottoChecker.checkResult(winningNumbers, playerNumbers);
        System.out.println("결과: " + result);
    }
}

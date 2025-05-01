import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LottoMachine lottoMachine = new LottoMachine();
        Player player = new Player();
        boolean validInput = false;

        // 로또 구매 방식 선택
        while (!validInput) {
            System.out.println("로또 구매 방식을 선택하세요 (자동/수동):");
            String purchaseType = scanner.nextLine();

            if (purchaseType.equalsIgnoreCase("자동")) {
                player.generateAutomaticNumbers();
//                System.out.println("자동 생성된 로또 번호: " + Arrays.toString(player.getPlayerNumbers()));
                validInput = true;
            } else if (purchaseType.equalsIgnoreCase("수동")) {
                player.inputNumbers();
                validInput = true;
            } else {
                System.out.println("'자동' 또는 '수동'으로 다시 입력해주세요.");
            }
        }

        // 당첨 번호 및 보너스 번호 입력
        lottoMachine.inputWinningNumbers();
        lottoMachine.inputBonusNumber(lottoMachine.getWinningNumbers());

        int[] winningNumbers = lottoMachine.getWinningNumbers();
        int bonusNumber = lottoMachine.getBonusNumber();
        int[] playerNumbers = player.getPlayerNumbers();

        System.out.println("당첨 번호: " + Arrays.toString(winningNumbers) + ", 보너스 번호: " + bonusNumber);
        System.out.println("입력한 로또 번호: " + Arrays.toString(playerNumbers));

        LottoChecker lottoChecker = new LottoChecker();
        String result = lottoChecker.checkResult(winningNumbers, bonusNumber, playerNumbers);
        System.out.println("결과: " + result);

        scanner.close();
    }
}
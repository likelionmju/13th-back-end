import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class LottoMachine {
    private int[] winningNumbers = new int[6];

    public void inputWinningNumbers() {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> numbers = new HashSet<>();
        System.out.println("당첨 번호 6개 입력:");
        while (numbers.size() < 6) {
            int num = scanner.nextInt();
            if (num < 1 || num > 45 || numbers.contains(num)) {
                System.out.println("again");
                continue;
            }
            numbers.add(num);
        }
        int index = 0;
        for (int num : numbers) {
            winningNumbers[index++] = num;
        }
        Arrays.sort(winningNumbers);
    }

    public int[] getWinningNumbers() {
        return winningNumbers;
    }
}

class Player {
    private int[] playerNumbers = new int[6];

    public void inputNumbers() {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> numbers = new HashSet<>();
        System.out.println("로또 번호 6개 입력:");
        while (numbers.size() < 6) {
            int num = scanner.nextInt();
            if (num < 1 || num > 45 || numbers.contains(num)) {
                System.out.println("again");
                continue;
            }
            numbers.add(num);
        }
        int index = 0;
        for (int num : numbers) {
            playerNumbers[index++] = num;
        }
        Arrays.sort(playerNumbers);
    }

    public int[] getPlayerNumbers() {
        return playerNumbers;
    }
}

class LottoChecker {
    public String checkResult(int[] winningNumbers, int[] playerNumbers) {
        int matchCount = 0;
        for (int num : playerNumbers) {
            if (Arrays.binarySearch(winningNumbers, num) >= 0) {
                matchCount++;
            }
        }
        return switch (matchCount) {
            case 5 -> "1등";
            case 4 -> "2등";
            case 3 -> "3등";
            default -> "꽝";
        };
    }
}

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

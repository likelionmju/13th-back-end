import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class LottoMachine {
    private int[] winningNumbers = new int[6];
    private int bonusNumber;

    public void inputWinningNumbers() {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> numbers = new HashSet<>();
        System.out.println("\n당첨 번호 6개를 입력하세요:");
        while (numbers.size() < 6) {
            System.out.print("번호 입력: ");
            if (!scanner.hasNextInt()) {
                System.out.println("유효하지 않은 입력입니다. 정수를 입력해주세요.");
                scanner.next();
                continue;
            }
            int num = scanner.nextInt();
            if (num < 1 || num > 45 || numbers.contains(num)) {
                System.out.println("1~45 사이의 중복되지 않는 숫자를 입력해주세요.");
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

    public void inputBonusNumber(int[] winningNumbers) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("보너스 번호를 입력하세요:");
        while (true) {
            if (!scanner.hasNextInt()) {
                System.out.println("유효하지 않은 입력입니다. 정수를 입력해주세요.");
                scanner.next();
                continue;
            }
            bonusNumber = scanner.nextInt();
            if (bonusNumber < 1 || bonusNumber > 45) {
                System.out.println("1~45 사이의 숫자를 입력해주세요.");
            } else if (Arrays.binarySearch(winningNumbers, bonusNumber) >= 0) {
                System.out.println("보너스 번호는 당첨 번호와 중복될 수 없습니다. 다시 입력해주세요.");
            } else {
                break;
            }
        }
    }

    public int[] getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
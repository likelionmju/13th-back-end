import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Player {
    private int[] playerNumbers = new int[6];

    public void inputNumbers() {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> numbers = new HashSet<>();
        System.out.println("\n로또 번호 6개를 입력하세요:");
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
            playerNumbers[index++] = num;
        }
        Arrays.sort(playerNumbers);
    }

    public void generateAutomaticNumbers() {
        Random random = new Random();
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < 6) {
            numbers.add(random.nextInt(45) + 1);
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
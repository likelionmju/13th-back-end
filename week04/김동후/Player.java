import java.util.*;

public class Player {
    private int[] playerNumbers = new int[6];
    private Scanner scanner;

    public Player(Scanner scanner) {
        this.scanner = scanner;
    }

    public void inputPlayerNumbers() {
        Set<Integer> numbers = new HashSet<>();
        System.out.println("내 로또 번호를 입력하세요 (1~45 사이 중복 없이 6개): ");
        while (numbers.size() < 6) {
            int num = scanner.nextInt();
            if (num >= 1 && num <= 45 && !numbers.contains(num)) {
                numbers.add(num);
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력하세요: ");
            }
        }
        int i = 0;
        for (int num : numbers) {
            playerNumbers[i++] = num;
        }
        Arrays.sort(playerNumbers);
    }

    public int[] getPlayerNumbers() {
        return playerNumbers;
    }
}

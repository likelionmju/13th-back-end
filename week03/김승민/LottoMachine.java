import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LottoMachine {
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

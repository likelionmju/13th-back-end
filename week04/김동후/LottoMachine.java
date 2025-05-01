import java.util.*;

public class LottoMachine {
    private int[] winningNumbers = new int[6];
    private int bonusNumber;
    private Scanner scanner;
    private Random random = new Random();

    public LottoMachine(Scanner scanner) {
        this.scanner = scanner;
    }

    public void createWinningNumbers() {
        System.out.println("어떤 방식의 로또를 구매하시겠습니까? (1. 자동 2. 수동): ");
        int choice = scanner.nextInt();
        while (choice != 1 && choice != 2) {
            System.out.println("잘못 입력했습니다. 다시 입력하세요 (1. 자동 2. 수동): ");
            choice = scanner.nextInt();
        }

        if (choice == 1) {
            autoPick();
        } else {
            manualPick();
        }

        Arrays.sort(winningNumbers);
        System.out.println("당첨 번호: " + Arrays.toString(winningNumbers));
    }

    private void autoPick() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < 6) {
            numbers.add(random.nextInt(45) + 1);
        }
        int i = 0;
        for (int num : numbers) {
            winningNumbers[i++] = num;
        }
    }

    private void manualPick() {
        Set<Integer> numbers = new HashSet<>();
        System.out.println("1~45 사이 숫자 6개를 입력하세요 (중복 금지): ");
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
            winningNumbers[i++] = num;
        }
    }

    public void createBonusNumber() {
        while (true) {
            int num = random.nextInt(45) + 1;
            if (!contains(winningNumbers, num)) {
                bonusNumber = num;
                break;
            }
        }
        System.out.println("보너스 번호: " + bonusNumber);
    }

    private boolean contains(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) return true;
        }
        return false;
    }

    public int[] getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}

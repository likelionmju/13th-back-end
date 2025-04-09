import java.util.Scanner;

public class Player {
    static Scanner scanner = new Scanner(System.in);
    static int[] numbers = new int[6];

    public  void inputNumbers() {
        for (int i = 0; i < 6; i++) {
            numbers[i] = scanner.nextInt();
        }
    }

    public int[] getPlayerNumbers() {
        return numbers;
    }
}

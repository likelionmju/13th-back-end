import java.util.Scanner;
import java.util.Arrays;

public class Player {
    private int[] playerNumbers = new int[6];

    public void inputNumbers(Scanner scanner) {
        for (int i = 0; i < 6; i++) {
            playerNumbers[i] = scanner.nextInt();
        }
        Arrays.sort(playerNumbers);
    }

    public int[] getPlayerNumbers() {
        return playerNumbers;
    }
}

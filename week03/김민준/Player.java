import java.util.Scanner;

public class Player {
    private int[] playerNumbers = new int[6];
    public void inputNumbers() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            playerNumbers[i] = scanner.nextInt();
        }
    }
    public int[] getPlayerNumbers() {
        return playerNumbers;
    }
}
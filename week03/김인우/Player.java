import java.util.Scanner;

public class Player {
    private int[] numbers;

    public Player() {
        this.numbers = new int[6];
    }

    public int[] getPlayerNumbers() {
        return numbers;
    }

    public void inputNumbers(Scanner scanner) {
        for(int i=0; i<numbers.length; i++) {
            numbers[i]= scanner.nextInt();
        }
    }
}

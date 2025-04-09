package week03;

import java.util.Scanner;
public class Player {
    Scanner scanner = new Scanner(System.in);
    int [] number = new int[6];
    public int[] inputNumbers() {
        for (int i = 0; i < 6; i++) {
            number[i] = scanner.nextInt();
        }
        return number;
    }
    public int [] getPlayerNumbers() {
        return number;
    }
}

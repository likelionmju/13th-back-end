package week04;

import java.util.Random;

public class AutoPlayer extends Player {
    public Random rand = new Random();
    public int[] playerNumbers = new int[7];

    public void inputNumbers() {
        for (int i = 0; i < 7; i++) {
            int number = rand.nextInt(45) + 1;
            if (numberCheck(number, playerNumbers)) {
                playerNumbers[i] = number;
                i++;
            }
        }
    }

    public int[] getPlayerNumbers() {
        return playerNumbers;
    }
}

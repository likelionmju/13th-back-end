package week04;

import java.util.Scanner;

public abstract class Player {
    public abstract void inputNumbers();
    public abstract int[] getPlayerNumbers();

    public boolean numberCheck(int number, int[] playerNumbers) {
        for (int i = 0; i < playerNumbers.length; i++) {
            if (playerNumbers[i] == number) {
                return false;
            }
        }
        return true;
    }
}

package mutsa.week03_practice;

import java.util.Scanner;
public class Player {
    private int [] player_number = new int[6];
    public void inputNumbers() {
        Scanner scn = new Scanner(System.in);
        for (int i = 0; i <= 5; i++) {
            player_number[i] = scn.nextInt();

        }
    }

    public int[] getPlayerNumbers() {
        return player_number;

    }
}

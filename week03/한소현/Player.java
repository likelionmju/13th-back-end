package Week3;

import java.util.Scanner;

public class Player {
    private int[] getPlayerNumbers = new int[6];

    public void inputNumbers(){
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < getPlayerNumbers.length; i++){
            getPlayerNumbers[i] = sc.nextInt();
        }
    }

    public int[] getPlayerNumbers() {
        return getPlayerNumbers;
    }
}

import java.util.Scanner;
public class Player {
	  Scanner scn = new Scanner(System.in);
	    private int[] playerNumbers = new int[6];

	    void inputNumbers() {
	        for (int i = 0; i < playerNumbers.length; i++) {
	            playerNumbers[i] = scn.nextInt();
	        }
	    }

	    int[] getPlayerNumbers() {
	        return playerNumbers;
	    }
}

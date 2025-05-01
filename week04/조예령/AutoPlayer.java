import java.util.Random;

public class AutoPlayer extends Player {

        public Random random = new Random();
        public int[] playerNumbers = new int[7];

        public void inputNumbers() {
                int i = 0;
                while(i < 7) {
                        int randomNum = random.nextInt(45) + 1;
                        if (checkUnique(randomNum, playerNumbers)) {
                                playerNumbers[i] = randomNum;
                                i++;
                        }
                }
        }

        public int[] getPlayerNumbers() {
                return playerNumbers;
        }

}
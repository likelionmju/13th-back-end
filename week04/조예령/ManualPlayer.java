import java.util.Scanner;
import java.util.Random;

public class ManualPlayer extends Player {
    public Random random = new Random();
    public int[] playerNumbers = new int[7];

    public void inputNumbers() {
        Scanner scanner = new Scanner(System.in);
        int i=0;

        while (i < 6) {

            System.out.println((i+1) + "번째 로또 번호를 입력하세요 (1~45 사이의 정수여야 합니다):");

            try {
                String input = scanner.nextLine();
                int inputNumber = Integer.parseInt(input);

                if(inputNumber > 0 && inputNumber <= 45 && checkUnique(inputNumber, playerNumbers)) {
                    playerNumbers[i] = inputNumber;
                    i++;
                }
                else
                    System.out.println("1~45 사이의 중복없는 정수여야 합니다. 다시 입력하세요.");
            } catch (NumberFormatException e){
                System.out.println("1~45 사이의 중복없는 정수여야 합니다. 다시 입력하세요.");
            }
        }

        while (true) {
            int bonusNumber = random.nextInt(45) + 1;
            if (checkUnique(bonusNumber, playerNumbers)) {
                playerNumbers[6] = bonusNumber;
                break;
            }
        }
    }


    public int[] getPlayerNumbers() {
        return playerNumbers;
    }
}
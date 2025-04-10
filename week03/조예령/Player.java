import java.util.Scanner;

public class Player {
    static int[] playerNumbers = new int[6];

    public static void inputNumbers() {
        Scanner scanner = new Scanner(System.in);
        int i=0;

        while (i < 6) {
            System.out.println((i+1) + "번째 로또 번호를 입력하세요 (1~45 사이의 정수여야 합니다):");

            try {
                String input = scanner.nextLine();
                int inputNumber = Integer.parseInt(input);

                if(inputNumber > 0 && inputNumber <= 45) {
                    playerNumbers[i] = inputNumber;
                    i++;
                }
                else
                    System.out.println("1~45 사이의 정수여야 합니다. 다시 입력하세요.");
            } catch (NumberFormatException e){
                System.out.println("1~45 사이의 정수여야 합니다. 다시 입력하세요.");

            }

        }
    }

    public static int[] getPlayerNumbers() {
        return playerNumbers;
    }
}

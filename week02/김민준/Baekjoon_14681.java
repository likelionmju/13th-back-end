import java.util.Scanner;

public class Baekjoon_14681 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int posX = scanner.nextInt();
        int posY = scanner.nextInt();

        if (posX > 0) {
            if (posY > 0) System.out.println(1);
            else System.out.println(4);
        } else {
            if (posY > 0) System.out.println(2);
            else System.out.println(3);
        }
    }
}

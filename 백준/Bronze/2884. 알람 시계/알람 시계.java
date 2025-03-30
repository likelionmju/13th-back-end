import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int H = scanner.nextInt();
        int M = scanner.nextInt();

        if (H < 0 || H >= 24 || M < 0 || M >= 60) {
            System.out.println("잘못된 입력입니다.");
        }

        if (0 <= H && M - 45 < 0) {
            if (H > 0) {
                System.out.println(H - 1 + " " + (60 - (45 - M)));
            }
            else if (H == 0){
                System.out.println("23 " + (60 - (45 - M)));
            }
        }
        else {
            System.out.println(H + " " + (M - 45));
        }
    }
}
import java.util.Scanner;

public class Star {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt(); //출력할 별의 단 수
        for (int i = 1; i <= count; i++) { //공란 출력
            for (int k = 1; k <= count - i; k++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) { //별 출력
                System.out.print("*");
            }
            System.out.println(); //Enter
        }
        scanner.close(); //스캐너 닫기
    }
}

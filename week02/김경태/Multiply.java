import java.util.Scanner;

public class Multiply {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first = scanner.nextInt();
        int second = scanner.nextInt();
        int a = 1; //일의 자리, 십의 자리, 백의 자리 수를 구하기 위한 변수
        for (int i = 1; i <= 3; i++) {
            a *= 10;
            int b = second % a; //두번째로 입력받은 값의 나머지를 구함
            b /= a/10; //나머지에서 사용할 값만 구함
            System.out.println(first * b); //계산값 출력
        }
        System.out.println(first * second); //두개의 수 최종 계산값 출력
        scanner.close(); //스캐너 닫기
    }
}

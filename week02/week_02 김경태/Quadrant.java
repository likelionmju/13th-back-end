import java.util.Scanner;

public class Quadrant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt(); //X좌표 입력
        int y = scanner.nextInt(); //Y좌표 입력
        if (x > 0 && y >0) { // 1사분면인 경우
            System.out.println("1");
        }
        else if (x< 0 && y >0) { //2사분면인 경우
            System.out.println("2");
        }
        else if (x < 0 && y < 0) { //3사분면인 경우
            System.out.println("3");
        }
        else { //4사분면인 경우
            System.out.println("4");
        }
        scanner.close();
    }
}

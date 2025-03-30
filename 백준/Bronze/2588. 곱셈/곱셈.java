import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        System.out.println(x * (y % 10));
        System.out.println(x * ((y / 10) % 10));
        System.out.println(x * (y / 100));
        System.out.println(x * y);
    }
}
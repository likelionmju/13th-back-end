import java.util.Scanner;

public class code2884 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int h = scanner.nextInt();
        int m = scanner.nextInt();

        if (m >= 0 && m <= 44) {
            if (h >= 1 && h <= 23) {
                System.out.println(h - 1);
                System.out.println(m + 15);
            } else {
                System.out.println(23);
                System.out.println(m + 15);
            }
        } else {
            System.out.println(h);
            System.out.println(m - 45);
        }
    }
}
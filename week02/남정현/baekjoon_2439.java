package mutsa.beakjoon;
import java.util.Scanner;

public class baekjoon_2439 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print(" ".repeat(n - i));
            System.out.println("*".repeat(i));
        }
    }
}
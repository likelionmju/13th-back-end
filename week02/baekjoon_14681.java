package mutsa.beakjoon;

import java.util.Scanner;

public class baekjoon_14681 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        if (x > 0 && y > 0) System.out.println(1);      // 1사분면
        else if (x < 0 && y > 0) System.out.println(2); // 2사분면
        else if (x < 0 && y < 0) System.out.println(3); // 3사분면
        else System.out.println(4);                     // 4사분면
    }
}

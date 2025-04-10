package mutsa.beakjoon;
import java.util.Scanner;

public class baekjoon_2588 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        String b = scn.next();

        int b1 = b.charAt(2) - '0';
        int b2 = b.charAt(1) - '0';
        int b3 = b.charAt(0) - '0';
        // 문자열 숫자를 문자열 0으로 빼주어 정수형으로 만듬
        System.out.println(a * b1);
        System.out.println(a * b2);
        System.out.println(a * b3);
        System.out.println(a * Integer.parseInt(b));
    }}


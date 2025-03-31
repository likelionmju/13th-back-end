package mutsa.beakjoon;
import java.util.Scanner;
public class baekjoon_10818 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int min = Integer.MAX_VALUE; // 갱신하기위해 가장 큰 값 저장
        int max = Integer.MIN_VALUE; // 갱신하기위해 가장 작은 값 저장

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();

            if (num < min) min = num;
            if (num > max) max = num;
        }

        System.out.println(min + " " + max);
    }
}

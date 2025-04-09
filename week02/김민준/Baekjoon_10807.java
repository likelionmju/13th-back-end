import java.io.IOException;
import java.util.Scanner;

public class Baekjoon_10807 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] arr = new int[number];

        for (int i = 0; i < number; i++) {
            arr[i] = scanner.nextInt();
        }

        int find = scanner.nextInt();
        int count = 0;
        for (int i = 0; i < number; i++) {
            if (arr[i] == find) {
                count++;
            }
        }
        System.out.println(count);
    }
}

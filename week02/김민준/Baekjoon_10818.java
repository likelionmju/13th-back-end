import java.util.Scanner;

public class Baekjoon_10818 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        int first_value = scanner.nextInt();
        int max = first_value;
        int min =  first_value;

        for (int i = 1; i < count; i++) {
            int number = scanner.nextInt();
            if (number < min) min = number;
            if (number > max) max = number;
        }
        System.out.println(min + " " + max);
    }
}

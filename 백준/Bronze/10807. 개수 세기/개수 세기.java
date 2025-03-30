import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] numbers = new int[num];
        int count = 0;

        for(int i = 0; i < num; i++) {
            numbers[i] = scanner.nextInt();
        }

        int same = scanner.nextInt();

        for(int i = 0; i < numbers.length; i++) {
            if(same == numbers[i]) {
                count ++;
            }
        }
        System.out.println(count);
        scanner.close();
    }
}
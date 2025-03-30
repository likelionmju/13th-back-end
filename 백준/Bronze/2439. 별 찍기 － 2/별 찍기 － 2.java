import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int j;

        for(int i = 1; i <= num; i++) {
            for(j = 1; j <= num - i; j++){
                System.out.print(" ");
            }
            for (j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        scanner.close();
    }
}
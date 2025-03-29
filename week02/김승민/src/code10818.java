import java.util.Scanner;

public class code10818 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int min = 1000001, max = -1000001;
        for (int i = 0; i < N; i++) {
            int cur = scan.nextInt();
            min = Math.min(min, cur);
            max = Math.max(max, cur);
            }
            System.out.println(min+" "+max);
        }

    }

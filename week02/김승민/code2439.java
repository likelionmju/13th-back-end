import java.util.Scanner;

public class code2439 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();

        for (int i=0; i<a; i++){
            for (int j=0;j<a-i-1;j++){
                System.out.print(" ");
            }
            for (int k=0;k<i+1;k++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}

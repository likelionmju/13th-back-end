

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        int a = (n2/100);
        int b = ((n2%100)/10);
        int c = ((n2%100)%10);

        System.out.println(c*n1);
        System.out.println(b*n1);
        System.out.println(a*n1);
        System.out.println(n1*n2);



    }
}

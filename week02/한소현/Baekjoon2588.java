package Week2;

import java.util.Scanner;

public class Baekjoon2588 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int f = sc.nextInt();
        int s = sc.nextInt();

        int si = f*s;
        int t = f*(s%10);
        s/=10;
        int fo = f*(s%10);
        s/=10;
        int fi = f*s;

        System.out.println(t);
        System.out.println(fo);
        System.out.println(fi);
        System.out.println(si);
        sc.close();
    }
}

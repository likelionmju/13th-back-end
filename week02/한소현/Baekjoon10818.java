package Week2;

import java.util.Scanner;

public class Baekjoon10818 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] IntArray = new int[N];

        int min = 1000000;
        int max =-1000000;

        for (int i = 0; i < N; i++){
            IntArray[i] = sc.nextInt();
            if (IntArray[i] > max)
                max = IntArray[i];
            if (IntArray[i] < min)
                min = IntArray[i];
        }

        System.out.println(min + " " + max);
    }
}

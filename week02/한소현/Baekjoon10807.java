package Week2;

import java.util.Scanner;

public class Baekjoon10807 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] numArray = new int[N];

        for (int i = 0; i < N; i++){
            numArray[i] = sc.nextInt();
        }
        int V = sc.nextInt();
        int count = 0;
        for (int j = 0; j < N; j++){
            if(numArray[j] == V) count++;
        }
        System.out.println(count);
        sc.close();
    }
}

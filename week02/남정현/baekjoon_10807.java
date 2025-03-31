package mutsa.beakjoon;
import java.util.Scanner;
public class baekjoon_10807 {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] nums = new int[n]; // nums라는 리스트에 정수n개 저장

    for (int i = 0; i < n; i++) {
        nums[i] = sc.nextInt();
    }

    int v = sc.nextInt();
    int count = 0;

    for (int num : nums) { //배열이나 리스트 순서대로 돌기만 할 때 사용
        if (num == v) count++;
    }

    System.out.println(count);
}
}

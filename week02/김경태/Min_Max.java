import java.util.Scanner;

public class Min_Max {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt(); //입력받을 정수의 갯수
        int min = 0;
        int max = 0;
        for (int i = 0; i <count; i++) {
            int num = scanner.nextInt();
            if (min ==0 && max ==0){ //최소값과 최대값이 없을때 처음으로 입력받은 수가 최소, 최대가 됨
                min = num;
                max = num;
            }
            else if (min > num) { // 기존에 있던 최소값보다 작은 수가 있으면 대체
                min = num;
            }
            else if (max < num) { //기존에 있던 최대값보다 큰수가 있으면 대체
                max = num;
            }
        }
        System.out.println(min + " " + max); //최소값, 최대값 출력
        scanner.close(); //스캐너 닫기
    }
}

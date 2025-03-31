import java.util.Scanner;

public class Count {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Total = scanner.nextInt(); //입력받을 정수의 갯수
        int [] intArray = new int[Total];
        for (int i = 0; i < Total; i++) { //입력받은 정수를 어레이에 입력
            int num = scanner.nextInt();
            intArray[i] = num;
        }
        int Find = scanner.nextInt(); //찾을 정수를 입력
        int count = 0;
        for (int i = 0; i < Total; i++) {
            if (intArray[i] == Find) {
                count += 1;
            }
        }
        System.out.println(count); //정수의 갯수를 출력
        scanner.close(); //스캐너 닫기
    }
}

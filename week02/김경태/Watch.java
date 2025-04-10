import java.util.Scanner;

public class Watch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int H = scanner.nextInt(); //시 입력
        int M = scanner.nextInt(); //분 입력
        int a = M-45; //45분 빼기
        if (a<0) { //시간에서도 빼야하는 경우
            H -= 1;
            M = 60 + a;
        }
        else { //시간에서 안빼도 되는 경우
            M -= a;
        }
        if (H<0 ) { //시간이 음수가 되는 경우
            H = 23;
        }
        System.out.println(H + " " + M);
        scanner.close();
    }
}

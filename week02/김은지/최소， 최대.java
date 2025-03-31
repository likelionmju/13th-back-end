
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr [] =  new int [n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt(); //사용자가 입력한 값
        }
        int max = arr[0];
        int min = arr[0];

        for (int i = 0; i < n; i++) {
            if(arr[i]>max){
                max=arr[i];
            }if(arr[i]<min){
                min=arr[i];
            }
        }System.out.println(min+" "+max);

    }


}

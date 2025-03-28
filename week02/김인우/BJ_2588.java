import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2588 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n1 = Integer.parseInt(br.readLine());
        //자리수 구분해서 저장
        String[] n2 = br.readLine().split("");
        int[] calculator = new int[n2.length];
        int result = 0;
        for(int i=0; i<n2.length; i++) {
            calculator[i] = n1*Integer.parseInt(n2[i]);
            result += calculator[i]*Math.pow(10,n2.length-1-i);
        }
        for(int i=calculator.length-1; i>=0; i--) {
            System.out.println(calculator[i]);
        }
        System.out.println(result);
    }
}

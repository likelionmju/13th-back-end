import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2439 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        for(int i=1; i<=N; i++) {
            for(int j=0; j<N-i; j++) {
                result.append(" ");
            }
            for(int j=N-i; j<N; j++) {
                result.append("*");
            }
            result.append("\n");
        }
        System.out.println(result);
    }
}
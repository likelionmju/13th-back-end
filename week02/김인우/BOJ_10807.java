import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10807 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        int v = Integer.parseInt(br.readLine());
        int result = 0;
        for(int i=0; i<N; i++) {
            if(Integer.parseInt(line[i])==v) {
                result++;
            }
        }
        System.out.println(result);
    }
}
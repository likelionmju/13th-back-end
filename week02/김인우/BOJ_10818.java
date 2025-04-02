import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10818 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        int max = Integer.parseInt(line[0]);
        int min = Integer.parseInt(line[0]);
        for(int i=1; i<N; i++) {
            int num = Integer.parseInt(line[i]);
            if(num>max) {
                max = num;
            } else if(num<min) {
                min = num;
            }
        }
        System.out.println(min+" "+max);
    }

}
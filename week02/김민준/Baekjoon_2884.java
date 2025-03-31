import java.util.*;

public class Baekjoon_2884 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hour = scanner.nextInt();
        int min = scanner.nextInt();

        if (min >= 45) {
            min -= 45;
        } else {
            if (hour == 0) {
                hour = 23;
                min += 15;
            } else {
                hour -= 1;
                min += 15;
            }
        }
        System.out.println(hour + " " + min);

        /*
            45분 up : 그저 -45
            45분 down : hour -1, 60-(45-min)
                                 15+min
        */
    }
}

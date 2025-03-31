

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first= scanner.nextInt();
        int second= scanner.nextInt();

        if (first>0){
            if(second>0){
               System.out.println(1);
            }else{
                System.out.println(4);
            }
        }else{
            if(second>0){
                System.out.println(2);
            }else{
                System.out.println(3);
            }
        }
    }
}

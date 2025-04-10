import java.util.InputMismatchException;
import java.util.Scanner;

public class Player extends Human{
    private Scanner scanner;
    static final int LOTTO_SIZE = 6;
    public Player() {super(LOTTO_SIZE);}

    public void drawNumbers() {
        scanner = new Scanner(System.in);
        //drawSelect() => 자동/수동 선택하는 메서드(return 값: 자동->1/수동->2)
        int select = drawSelect();
        draw(select);   //draw(1or2)
    }

    private int drawSelect() {
        System.out.println("로또 구매 방식을 선택하세요.");
        while(true) {
            try {
                System.out.printf("1. 자동 | 2. 수동 : ");
                int select = scanner.nextInt();
                scanner.nextLine();
                if(select==1||select==2) { //올바른 숫자 입력->return(반복문 종료)
                    return select;
                } else { // 1,2가 아닌 숫자 입력->다시 입력
                    System.out.println("1 또는 2 를 입력해주세요.");
                }
            } catch(InputMismatchException e) {//숫자가 아닐 때->다시 입력
                scanner.nextLine();
                System.out.println("숫자를 입력해주세요.");
            }
        }
    }

    private void draw(int select) {
        if(select==1)   {
            System.out.println("1번을 선택하셨습니다.");
            System.out.println("자동으로 6개의 숫자를 설정하겠습니다. ");
            this.getLotto().autoSet(); //Lotto 자동 뽑기
            System.out.println("6개의 숫자가 설정되었습니다.");
        }
        if(select==2)   {
            System.out.println("2번을 선택하셨습니다.");
            System.out.println("6개의 숫자를 하나씩 입력해주세요.");
            this.getLotto().manualSet(scanner); //Lotto 수동 뽑기
        }
    }
}

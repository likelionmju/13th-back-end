package Week4;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private ArrayList<Integer> userNum = new ArrayList<>();
    private int userBonus;

    public void lottoCreat(){
        Scanner sc = new Scanner(System.in);
        System.out.println("로또 생성기 입니다.");
        System.out.println("생성 방식을 선택해주세요");
        System.out.println("1 : 자동   2 : 수동 (그 외 입력시 종료됩니다.)");
        while (true) {
            int num = sc.nextInt();
            Lotto_I lotto;
            if(num == 1){
                lotto = new AutoLotto();
                userNum = lotto.lottoget();
                userBonus = lotto.bonusGet(userNum);
                break;
            } else if (num == 2) {
                lotto = new ManualLotto();
                userNum = lotto.lottoget();
                userBonus = lotto.bonusGet(userNum);
                break;
            } else {
                System.out.println("잘못 입력하셨습니다.");
            }
        }
    }

    public void lottoCheck(Lotto lotto){
        lotto.lottoChecker(userNum,userBonus);
    }
}

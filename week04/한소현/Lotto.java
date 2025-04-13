package Week4;

import java.util.ArrayList;

public class Lotto {
    private final ArrayList<Integer> lottoNum;
    private final int bonusNum;
    private Lotto_I lottoI = new AutoLotto();

    public Lotto(){
        lottoNum = lottoI.lottoget();
        bonusNum = lottoI.bonusGet(lottoNum);
    }

    public void lottoChecker(ArrayList<Integer> list, int i){
        System.out.println("당첨 번호 : " + lottoNum.toString() + " 보너스 번호 : " + bonusNum);
        System.out.println("내 번호 : " + list.toString() + " 보너스 번호 : " + i);
        System.out.print("당첨 결과 : ");
        int count = 0;
        boolean bonus = false;
        for(Integer l : lottoNum){
            for(Integer ul : list){
                if(l == ul) count++;
            }
        }
        if(bonusNum == i) bonus = true;

        switch (count){
            case 6:
                System.out.println("1등");
                break;
            case 5:
                if(bonus){
                    System.out.println("2등");
                }else System.out.println("3등");
                break;
            case 4:
                System.out.println("4등");
                break;
            case 3:
                System.out.println("5등");
                break;
            default:
                System.out.println("꽝");
                break;
        }
    }
}

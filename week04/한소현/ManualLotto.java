package Week4;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ManualLotto implements Lotto_I{
    @Override
    public ArrayList<Integer> lottoget() {
        ArrayList<Integer> list = null;
        list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int count = 0;
        System.out.println("로또 번호를 입력해주세요.");
        while (count < 6){
            int num = 0;
            try {
                num = sc.nextInt();

                if (numCheck(list, num)) {
                    list.add(num);
                    count++;
                }
            } catch (InputMismatchException e){
                sc = new Scanner(System.in);
                System.out.println("정수를 입력해주세요.");
            }
        }
        return list;
    }

    @Override
    public int bonusGet(ArrayList<Integer> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("보너스번호를 입력해주세요.");
        while (true){
            try {
                int num = sc.nextInt();
                if(numCheck(list, num)){
                    return num;
                }
            } catch (InputMismatchException e) {
                sc = new Scanner(System.in);
                System.out.println("정수를 입력해주세요.");
            }
        }
    }
    @Override
    public boolean numCheck(ArrayList<Integer> list, int i){
        if(i < 1 || 45 < i){
            System.out.println("입력 범위를 넘어갔습니다.");
            System.out.println("다시 입력해주세요.");
            return false;
        } else if (list.contains(i)){
            System.out.println("중복되었습니다.");
            System.out.println("다시 입력해주세요");
            return false;
        } else return true;
    }

}

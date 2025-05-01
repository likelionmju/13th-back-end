package Week4;

import java.util.ArrayList;

public class AutoLotto implements Lotto_I{
    @Override
    public ArrayList<Integer> lottoget() {
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;
        while (count < 6){
            int num = (int)(Math.random()*100);
            if(numCheck(list, num)) {
                list.add(num);
                count++;
            }
        }
        return list;
    }

    @Override
    public int bonusGet(ArrayList<Integer> list) {
        while (true){
            int num = (int)(Math.random()*100);
            if(numCheck(list, num)){
                return num;
            }
        }
    }

    @Override
    public boolean numCheck(ArrayList<Integer> list, int i) {
        if(i < 0  || i > 45){
            return false;
        } else return !list.contains(i);
    }
}

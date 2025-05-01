package Week4;

import java.util.ArrayList;

public interface Lotto_I {
    public ArrayList<Integer> lottoget();

    public int bonusGet(ArrayList<Integer> list);
    public boolean numCheck(ArrayList<Integer> list, int i);
}

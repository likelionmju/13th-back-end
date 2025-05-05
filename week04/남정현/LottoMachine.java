package mutsa.week03_practice;
import java.util.concurrent.ThreadLocalRandom;
import java.util.HashSet;
import java.util.Set;
public class LottoMachine {
    int lotto_bonusnumber;
    Set<Integer> winningNumber = new HashSet<>();

    public void drawNumbers() {
        while (winningNumber.size() < 6){
            int number = ThreadLocalRandom.current().nextInt(1, 46);
            winningNumber.add(number);

            }
        while (true) {
            int bonus = ThreadLocalRandom.current().nextInt(1, 46);
            if (!winningNumber.contains(bonus)) {
                lotto_bonusnumber = bonus;
                break;
            }
        }}

    public Set<Integer> getWinningNumbers() {
        return winningNumber;


        }

    public int getBonusNumber() {
        return lotto_bonusnumber;
    }


}

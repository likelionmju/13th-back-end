import java.util.*;

public class LottoMachine {
    private int[] winningNumbers = new int[6];
    private int bonusNumber;
    //당첨번호 6개 보너스번호 1개 생성메서드
    public void generateNumbers() {
        Random rand = new Random();
        Set<Integer> numberSet = new HashSet<>();
        // 중복제거위해 set 사용
        while (numberSet.size() < 6) {
            int temp = rand.nextInt(45) + 1;
            numberSet.add(temp);
        }
        int numberIndex = 0;
        for (int num : numberSet) { // 배열로 옮김
            winningNumbers[numberIndex++] = num;
        }
        bonusNumber = rand.nextInt(45) + 1;
        // bonusnumber 가 겹치면 계속 반복
        while (numberSet.contains(bonusNumber)) {
            bonusNumber = rand.nextInt(45) + 1;
        }
        System.out.println("당첨 번호: " + Arrays.toString(winningNumbers) + " + 보너스 번호: " + bonusNumber);
    }
    //배열형태로 반환
    public int[] getWinningNumbers() {
        return winningNumbers;
    }
// 보너스번호 1개만 반환
    public int getBonusNumber() {
        return bonusNumber;
    }
}
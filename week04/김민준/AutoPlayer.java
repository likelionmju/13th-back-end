import java.util.*;

public class AutoPlayer implements Player {
    private int[] numbers = new int[6];

    public AutoPlayer() {
        Random rand = new Random();
        Set<Integer> numberSet = new HashSet<>();

        while (numberSet.size() < 6) {
            int temp = rand.nextInt(45) + 1;
            numberSet.add(temp);
        }

        int numberIndex = 0;
        for (int num : numberSet) {
            numbers[numberIndex++] = num;
        }
    }
    @Override
    public int[] getNumbers() {
        return numbers;
    }
    @Override
    public void printNumbers() {
        System.out.println("자동 생성 번호: " + Arrays.toString(numbers));
    }
}
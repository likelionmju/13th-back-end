package week04;
import java.util.Random;

public class Lotto {
    Random rand = new Random();
    int[] numbers = new int[6];

    protected int drawNumber() {
        int temp = rand.nextInt(45)+1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == temp) {
                temp = drawNumber();
            }
        }
        return temp;
    }

    public int[] getNumber() {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = drawNumber();
        }
        return numbers;
    }

    public void printNumbers() {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
    }
}
import java.util.*;

public class ManualPlayer implements Player {
    private int[] numbers = new int[6];

    public ManualPlayer() {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> numberSet = new HashSet<>();

        System.out.println("1~45 숫자 6개를 입력하세요 (중복x):");


        while (numberSet.size() < 6) {
            try {
                System.out.print((numberSet.size() + 1) + "번째 숫자: ");
                int temp = scanner.nextInt();

                if (temp < 1 || temp > 45) {
                    throw new IllegalArgumentException("1~45 사이 숫자만 입력 가능.");
                }
                if (numberSet.contains(temp)) {
                    throw new IllegalArgumentException("숫자는 중복될수 없습니다. 다른 숫자를 입력하세요.");
                }
                numberSet.add(temp); // 유효하면 추가
            } catch (IllegalArgumentException e) {
                System.out.println("입력 오류: " + e.getMessage());
            }
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
        System.out.println("수동 입력 번호: " + Arrays.toString(numbers));
    }
}
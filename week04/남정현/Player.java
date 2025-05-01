package mutsa.week03_practice;
import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;
public class Player {
    Set<Integer> player_number = new HashSet<>();
    int player_bonusNumber;
    public void inputNumbers() {
        Scanner scn = new Scanner(System.in);
        System.out.println("6개의 로또번호를 입력하세요 : ");

        while (player_number.size() < 6){
            int number = scn.nextInt();

            try {
                if (number < 1 || number > 45) {
                    throw new IllegalArgumentException("1부터 45 사이 숫자만 입력하세요");
                }
                if (player_number.contains(number)) {
                    System.out.println(6-player_number.size()+"개의 번호를 다시 입력하세요.");
                    continue;
                }
                player_number.add(number);
            } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
            }
        }
        while (true) {
            int bonus = scn.nextInt();
            try {
                if (bonus < 1 || bonus > 45) {
                    throw new IllegalArgumentException("1부터 45 사이 숫자만 입력하세요");
                }

                if (player_number.contains(bonus)) {
                    throw new IllegalArgumentException("중복 번호입니다. 다른 번호를 입력하세요.");
                }

                player_bonusNumber = bonus; // 정상 입력되면 저장
                break; // 보너스 입력 완료 후 while 탈출
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
    }}
    public Set<Integer> getPlayerNumbers() {
        return player_number;

    }

    public int getPlayerBonusNumber() {
        return player_bonusNumber;
}}

import java.util.Scanner;

public class LottoMachineTest {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		LottoMachine lottoMachine = new LottoMachine(); // 로또 머신 객체
		lottoMachine.drawNumbers();// 로또머신에서 번호 뽑음

		// 사용자가 자동, 수동 선택

		System.out.print("자동/수동: ");
		String select = scn.next();// 자동/ 수동 입력

		Player player = new Player(); // 플레이어 객체 생성
		player.pSelect(select); // 플레이어의 응답 리턴

		int[] winningNumbers = lottoMachine.getWinningNumbers();// 로또번호저장

		int bonusN = lottoMachine.getbonus(); // 보너스 넘버

		int[] playerNumbers = player.getPlayerNumbers(); // 플레이어넘버저장
		System.out.print("로또당첨번호:");
		for (int i = 0; i < winningNumbers.length; i++) {
			System.out.print(winningNumbers[i] + " ");
		}
		System.out.println();

		System.out.println("보너스 번호: " + bonusN);
		System.out.print("플레이어 번호:");
		for (int i = 0; i < playerNumbers.length; i++) {
			System.out.print(playerNumbers[i] + " ");
		}
		System.out.println();
		LottoChecker lottoChecker = new LottoChecker();
		String result = lottoChecker.checkResult(winningNumbers, playerNumbers, bonusN);
		System.out.println("결과: " + result);

	}
}
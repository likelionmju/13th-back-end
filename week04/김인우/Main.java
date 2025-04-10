public class Main {
    public static void main(String[] args) {
        Dealer dealer = new Dealer();
        dealer.drawNumbers();
        test(dealer.getLotto().getLottoNums()); //당첨 번호 콘솔에 공개

        Player player = new Player();
        player.drawNumbers();

        LottoChecker lottoChecker = new LottoChecker(
                dealer.getLotto(), player.getLotto());
        lottoChecker.checkResult();
        lottoChecker.announceResult();
    }

    public static void test(int[] lottoNums) {
        //당첨결과가 잘 나오는지 Test하기 위한 코드(없어도 됨)
        System.out.printf("Test: 당첨 번호를 공개하겠습니다.");
        System.out.println(" 7번째 번호는 보너스번호입니다.");
        for(int num:lottoNums) {
            System.out.printf(num+" ");
        }
        System.out.println();
    }
}
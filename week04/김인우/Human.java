public class Human {
    private Lotto lotto;

    public Human(int size) {
        this.lotto = new Lotto(size);
    }

    public Lotto getLotto() {
        return lotto;
    }

    public void drawNumbers(){}
}

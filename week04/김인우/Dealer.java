

public class Dealer extends Human{
    static final int LOTTO_SIZE = 7;
    public Dealer() {
        super(LOTTO_SIZE);
    }
    public void drawNumbers() {
        this.getLotto().autoSet();
    }
}

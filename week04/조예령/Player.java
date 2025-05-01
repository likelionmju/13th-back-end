
public abstract class Player {
    public abstract void inputNumbers();
    public abstract int[] getPlayerNumbers();

    public boolean checkUnique(int num, int[] playerNumbers) {
        for (int n : playerNumbers) {
            if (n != 0 && n == num) {
                return false;
            }
        }
        return true;
    }
}

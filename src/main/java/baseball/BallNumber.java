package baseball;

public class BallNumber {
    public int num;
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 9;

    public BallNumber(int num) {
        getBallNum(num);
    }

    public void getBallNum(int num) {
        if (num < MIN_NUM || num > MAX_NUM) {
            throw new IllegalArgumentException("숫자는 1부터 9의 값이어야한다.");
        }
        this.num = num;
    }
}

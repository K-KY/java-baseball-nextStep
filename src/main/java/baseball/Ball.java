package baseball;

import java.util.Objects;

public class Ball {
    private final int position;
    private final BallNumber ballNum;

    public Ball(int position, int ballNum) {
        this.position = position;
        //this.ballNum = ballNum;
        this.ballNum = new BallNumber(ballNum); //이렇게 했을 때 new 로 새로운 인스턴스를 생성하면서 다른 클래스가 되어버림

    }

    public BallStatus play(Ball ball) {
        if (this.position == ball.position && this.ballNum.num == ball.ballNum.num) {
            return BallStatus.STRIKE;
        }

        if (ball.matchBallNum(ballNum.num)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    private boolean matchBallNum(int ballNum) {
        return this.ballNum.num == ballNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position && ballNum == ball.ballNum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, ballNum);
    }
}

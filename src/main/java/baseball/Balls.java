package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls implements Playable {
    private final List<Ball> balls;
    //컴퓨터가 생성한 번호

    public Balls(List<Integer> answers) {
        this.balls = mapBall(answers);
    }

    //메소드에서 클래스의 멤버 변수 메소드 (static 이후에 로드 되는것들) 을 사용하지 않는다면 static 을 붙이는것을 고려한다.
    private static List<Ball> mapBall(List<Integer> answers) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            balls.add(new Ball(i + 1, answers.get(i)));
        }
        return balls;
    }

    public BallStatus play(Ball userBall) {
        //balls 에는 ball 객체가 저장 되어 있기떄문에 ball 의 메소드를 사용 가능
        return balls.stream()
                .map(answer -> answer.play(userBall))
                //nothing 가 아닌경우만 필터
                .filter(BallStatus::isNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }
    public PlayResult play(List<Integer> balls) {
        PlayResult result = new PlayResult();
        Balls userBalls = new Balls(balls);
        for (int i = 0; i < balls.size(); i++) {
            BallStatus status = userBalls.play(this.balls.get(i));
            result.report(status);
        }
        return result;
    }
    /**
     * map() : 괄호 안의 함수가 적용된 리스트를 반환한다.
     * filter() : 조건을 만족하는 값만 걸러낸다.
     * findFirst() : 조건에 부합하는 가장 첫번째 값을 반환
     */
}

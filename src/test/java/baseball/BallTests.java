package baseball;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BallTests {

    @Test
    void play_nothing() {
        Balls answer = new Balls(Arrays.asList(1, 2, 3));
        PlayResult result = answer.play(Arrays.asList(4, 5, 6));
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);

    }
    @Test
    void play_1s_1b() {
        Balls answer = new Balls(Arrays.asList(1, 2, 3));
        PlayResult result = answer.play(Arrays.asList(1, 3, 6));
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(1);

    }
    @Test
    void play_3s() {
        Balls answer = new Balls(Arrays.asList(1, 2, 3));
        PlayResult result = answer.play(Arrays.asList(1, 2, 3));
        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.isGameEnd()).isTrue();

    }
    @Test
    void play_1b() {
        Balls answer = new Balls(Arrays.asList(1, 2, 3));
        PlayResult result = answer.play(Arrays.asList(5, 4, 1));
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(1);
        assertThat(result.isGameEnd()).isFalse();

    }

    @Test
    void nothing() {
        Balls answer = new Balls(Arrays.asList(1, 2, 3));
        BallStatus status = answer.play(new Ball(1, 4));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void ball() {
        Balls answer = new Balls(Arrays.asList(1, 2, 3));
        BallStatus status = answer.play(new Ball(1, 3));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }
    @Test
    void strike() {
        Balls answer = new Balls(Arrays.asList(1, 2, 3));
        BallStatus status = answer.play(new Ball(1, 1));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }
}

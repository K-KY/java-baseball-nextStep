package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {
    private Ball gen;

    @BeforeEach
    void setUp() {
        gen = new Ball(1, 4);
    }
    @Test
    void nothing() {
        assertThat(gen.play(new Ball(2, 5))).isEqualTo(BallStatus.NOTHING);
    }
    @Test
    void ball() {
        assertThat(gen.play(new Ball(2, 4))).isEqualTo(BallStatus.BALL);
    }
    @Test
    void strike() {
        assertThat(gen.play(new Ball(1, 4))).isEqualTo(BallStatus.STRIKE);
    }
}

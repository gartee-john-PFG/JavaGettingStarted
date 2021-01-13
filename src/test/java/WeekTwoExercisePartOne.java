import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeekTwoExercisePartOne {

    /**
     * We can briefly summarize the scoring rules for bowling:
     *  Each game, or “line” of bowling, includes ten turns, or “frames” for the bowler.
     *
     *  In each frame, the bowler gets up to two tries to knock down all the pins.
     *
     * Open frame
     * If in two tries, they fail to knock them all down, this is called an "open frame"
     * the score for that frame is the sum of pins knocked down.
     *
     * Spare
     * If in two rolls they knocks them all down, this is called a "spare" and
     * the score for the frame is ten plus the next roll.
     *
     * Strike
     * If on the first roll in a frame all ten pins are knocked down, this is called a "strike" and
     * the score for the frame is ten plus the total of the next two rolls.
     *
     * The game score is the sum of all frame scores.
     */

    BowlingGame bowlingGame = new BowlingGame();

    @Test
    // TODO Response: Why did we start with this test?
    public void whenRollingAllGutterBallsScoreIsZero() {
        rollMany(20, 0);

        int actual = bowlingGame.score();

        assertEquals(0, actual);
    }

    @Test
    // TODO Response:  If the above test works with open frames, why is this test necessary?
    public void whenRollingOpenFrameScoreIsSumOfRolls() {
        rollMany(20, 1);

        int actual = bowlingGame.score();

        assertEquals(20, actual);
    }

    // TODO CODE: Start here
    @Test
    public void whenRollingSpareFrameScoreIsTenPlusNextRoll() {
        bowlingGame.roll(3);
        bowlingGame.roll(7);
        bowlingGame.roll(3);
        rollMany(17, 0);

        int actual = bowlingGame.score();

        assertEquals(16, actual);
    }

    @Test
    public void whenRollingStrikeFrameScoreIsTenPlusNextTwoRolls() {
        bowlingGame.roll(10);
        bowlingGame.roll(7);
        bowlingGame.roll(1);
        rollMany(16, 0);

        int actual = bowlingGame.score();

        assertEquals(26, actual);
    }

    //TODO Response: Why don't we need any more tests than these?

    private void rollMany(int rollCount, int pins) {
        for(int i = 0; i < rollCount; i++) {
            bowlingGame.roll(pins);
        }
    }
}
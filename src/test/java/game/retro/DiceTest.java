package game.retro;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.stream.IntStream;

public class DiceTest extends TestCase {

    @Test
    public void testRollShouldReturnNumberWithinInRange() {
        IntStream.range(1, 1000).forEach(value -> {
            int diceOutcome = Dice.roll();

            assert IntStream.rangeClosed(1, 6).anyMatch(val -> val == diceOutcome);
        });
    }
}
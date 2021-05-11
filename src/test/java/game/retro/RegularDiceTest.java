package game.retro;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.stream.IntStream;

public class RegularDiceTest extends TestCase {

    @Test
    public void testRollShouldReturnNumberWithinInRange() {
        IntStream.range(1, 1000).forEach(value -> {
            Dice dice = new RegularDice();
            int diceOutcome = dice.roll();

            assert IntStream.rangeClosed(1, 6).anyMatch(val -> val == diceOutcome);
        });
    }
}
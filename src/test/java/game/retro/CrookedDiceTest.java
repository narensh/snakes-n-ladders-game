package game.retro;

import org.junit.Test;

import java.util.stream.IntStream;

import static java.util.Arrays.asList;

public class CrookedDiceTest {
    @Test
    public void testRollShouldReturnNumberWithinInRange() {
        IntStream.range(1, 1000).forEach(value -> {
            Dice crookedDice = new CrookedDice();
            int diceOutcome = crookedDice.roll();

            assert asList(2, 4, 6).stream().anyMatch(val -> val == diceOutcome);
        });
    }
}
package game.retro;

import org.junit.Test;

import static org.junit.Assert.*;

public class DiceBuilderTest {

    @Test
    public void testShouldReturnRegularDice() {
        Dice newDice = DiceBuilder.getNewDice(Dice.Type.REGULAR);
        assert newDice.getClass() == RegularDice.class;
    }

    @Test(expected = RuntimeException.class)
    public void testShouldRaiseErrorForInvalidDiceType() {
        DiceBuilder.getNewDice(Dice.Type.valueOf("FOOBAR"));
    }
}
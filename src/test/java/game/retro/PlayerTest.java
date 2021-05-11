package game.retro;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlayerTest {

    @Test
    public void rollDice() {
        Dice dice = mock(Dice.class);
        Player player = Player.builder().dice(dice).build();
        when(dice.roll()).thenReturn(4);

        int diceOutcome = player.throwDice();

        assert diceOutcome == 4;
    }

    @Test
    public void testGetNameShouldReturnName() {
        Player player = new Player("Player A", null);

        assert player.getName().equals("Player A");
    }

    @Test
    public void testBuilderShouldInitializeWithName() {
        Player player = Player.builder().name("Player A").build();

        assert player.getName().equals("Player A");
    }
}
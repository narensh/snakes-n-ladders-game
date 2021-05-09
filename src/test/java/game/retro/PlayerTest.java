package game.retro;

import org.junit.Test;
import org.mockito.MockedStatic;

import static org.mockito.Mockito.mockStatic;

public class PlayerTest {

    @Test
    public void rollDice() {
        Player player = Player.builder().build();
        MockedStatic diceStaticMock = mockStatic(Dice.class);

        diceStaticMock.when(() -> Dice.roll()).thenReturn(4);
        int diceOutcome = player.throwDice();

        assert diceOutcome == 4;
    }

    @Test
    public void testGetNameShouldReturnName() {
        Player player = new Player("Player A");

        assert player.getName() == "Player A";
    }

    @Test
    public void testBuilderShouldInitializeWithName() {
        Player player = Player.builder().name("Player A").build();

        assert player.getName() == "Player A";
    }
}
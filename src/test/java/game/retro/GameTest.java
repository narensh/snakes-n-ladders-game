package game.retro;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockedStatic;

import static org.mockito.Mockito.mockStatic;

public class GameTest extends TestCase {
    private int maxTurns = 3;
    private Game game;

    private final int BOARD_SIZE = 10;
    private final String playerName = "Player A";

    @Before
    public void setUp() throws Exception {
        game = Game.buildGame(BOARD_SIZE, playerName, maxTurns);
    }

    @Test
    public void testShouldBuildGameWithBoardSize() {
        assert game.getBoard().getSize() == BOARD_SIZE;
    }

    @Test
    public void testShouldBuildGameWithGivenPlayerName() {
        assert game.getPlayer().getName() == playerName;
    }

    @Test
    public void testShouldBuildGameSetMaxTurns() {
        assert game.getMaxTurns() == maxTurns;
    }

    @Test
    public void testPlayerShouldNotPlayBeyondMaxTurn() {
        try (MockedStatic diceStaticMock = mockStatic(Dice.class)) {
            diceStaticMock.when(() -> Dice.roll()).thenReturn(1, 2, 4);

            game.start();
        }
        assert game.getTurnCount() == maxTurns;
    }

    @Test
    public void testShouldNotMoveBeyondMaxPosition() {
        try (MockedStatic diceStaticMock = mockStatic(Dice.class)) {
            diceStaticMock.when(() -> Dice.roll()).thenReturn(1, 6, 5);

            game.start();
        }
        assert game.getBoard().getPlayerPosition() == 7;
    }

    @Test
    public void testShouldReturnTrueWhenMaxTurnsReached() {
        try (MockedStatic diceStaticMock = mockStatic(Dice.class)) {
            diceStaticMock.when(() -> Dice.roll()).thenReturn(1, 6, 5);

            game.start();
        }
        assert game.getMaxTurns() == maxTurns;
        assert game.isCompleted() == true;
    }

    @Test
    public void testShouldReturnTrueWhenPlayerHasWon() {
        try (MockedStatic diceStaticMock = mockStatic(Dice.class)) {
            diceStaticMock.when(() -> Dice.roll()).thenReturn(1, 6, 3);

            game.start();

        }

        assert game.getBoard().hasPlayerWon() == true;
        assert game.isCompleted() == true;
    }

    @Test
    public void testShouldReturnFalseWhenPlayerHasNotReachedTheMaxPosition() {
        assert game.isCompleted() == false;
    }
}
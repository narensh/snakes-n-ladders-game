package game.retro;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockedStatic;

import static org.mockito.Mockito.mockStatic;

public class GameTest extends TestCase {
    private Game game;
    private int maxTurns = 3;
    private final int boardSize = 10;
    private final String playerName = "Player A";
    private final int snakeStartPos = 9;
    private final int snakeEndPos = 2;

    @Before
    public void setUp() throws Exception {
        game = Game.buildGame(boardSize, playerName, maxTurns, snakeStartPos, snakeEndPos);
    }

    @Test
    public void testShouldBuildGameWithBoardSize() {
        assert game.getBoard().getSize() == boardSize;
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


    @Test
    public void testShouldMovePlayerPositionToSnakeEndPosition() {
        try (MockedStatic diceStaticMock = mockStatic(Dice.class)) {
            diceStaticMock.when(() -> Dice.roll()).thenReturn(5, 3, 1);

            game.start();
        }
        assert game.getBoard().getPlayerPosition() == 2;
    }
}
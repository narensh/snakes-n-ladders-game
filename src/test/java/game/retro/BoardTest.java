package game.retro;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BoardTest {

    @Test
    public void testBuilderShouldInitializeWithGivenSize() {
        Board board = Board.builder().size(10).build();

        assert board.getSize() == 10;
    }

    @Test
    public void testBuilderShouldSetDefaultPlayerPosition() {
        Board board = Board.builder().size(10).build();

        assert board.getPlayerPosition() == 0;
    }

    @Test
    public void testBuilderShouldInitializeWithGivenPlayer() {
        Player playerMock = mock(Player.class);
        Board board = Board.builder().player(playerMock).build();

        assert board.getPlayer() == playerMock;
    }

    @Test
    public void testShouldInitializeWithGivenSizeAndPlayer() {
        Player playerMock = mock(Player.class);
        Snake snakeMock = mock(Snake.class);
        Board board = new Board(10, playerMock, snakeMock);

        assert board.getSize() == 10;
        assert board.getPlayer() == playerMock;
        assert board.getSnake() == snakeMock;
    }

    @Test
    public void testShouldMovePlayer() {
        Player player = mock(Player.class);
        when(player.getName()).thenReturn("Player A");
        Board board = Board.builder().size(10).player(player).build();

        board.movePlayer(10);

        assert board.getPlayerPosition() == 10;
    }

    @Test
    public void testMovePlayerShouldNotChangePositionWhenOutOfBounds() {
        Player player = mock(Player.class);
        when(player.getName()).thenReturn("Player");
        Board board = Board.builder().size(10).player(player).build();

        board.movePlayer(99);

        assert board.getPlayerPosition() == 0;
    }

    @Test
    public void testSnakeShouldBiteWhenPlayerLandsOnit() {
        Snake snake = mock(Snake.class);
        Player player = mock(Player.class);
        Board board = Board.builder().size(10).snake(snake).player(player).build();

        when(snake.bite(9)).thenReturn(2);
        when(player.getName()).thenReturn("Player A");

        board.movePlayer(9);

        assert board.getPlayerPosition() == 2;
    }

    @Test
    public void testMovePlayerWhenSnakeIsNotDefined() {
        Snake snake = null;
        Player player = mock(Player.class);
        when(player.getName()).thenReturn("Player A");
        Board board = Board.builder().size(10).snake(snake).player(player).build();

        board.movePlayer(9);

        assert board.getPlayerPosition() == 9;
    }

    @Test
    public void testHasPlayerWonOnInitialize() {
        Board board = Board.builder().size(10).build();

        assert board.hasPlayerWon() == false;
    }

    @Test
    public void testHasPlayerWonPlayerReachedLastPositionOnBoard() {
        Player playerMock = mock(Player.class);
        when(playerMock.getName()).thenReturn("Player A");
        Board board = Board.builder().size(10).player(playerMock).build();

        board.movePlayer(10);

        assert board.hasPlayerWon() == true;
    }
}
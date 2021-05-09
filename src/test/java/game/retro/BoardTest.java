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
        Board board = new Board(10, playerMock);

        assert board.getSize() == 10;
        assert board.getPlayer() == playerMock;
    }

    @Test
    public void testShouldSetPlayerPosition() {
        Board board = Board.builder().size(10).build();

        board.setPlayerPosition(10);

        assert board.getPlayerPosition() == 10;
    }

    @Test(expected = RuntimeException.class)
    public void testSetPlayerPositionShouldRaiseWhenOutOfBounds() {
        Board board = Board.builder().size(10).build();

        board.setPlayerPosition(99);
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

        board.setPlayerPosition(10);

        assert board.hasPlayerWon() == true;
    }
}
package game.retro.exceptions;

import org.junit.Test;

public class PlayerOutOfBoundsExceptionTest {
    @Test
    public void testExceptionMessage() {
        PlayerOutOfBoundsException playerOutOfBoundsException = new PlayerOutOfBoundsException();

        assert playerOutOfBoundsException.getMessage().equals("Player can't go out of bounds of Board");
    }
}
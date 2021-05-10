package game.retro.exceptions;

import org.junit.Test;

public class InvalidSnakeExceptionTest {
    @Test
    public void testExceptionMessage() {
        InvalidSnakeException invalidSnakeException = new InvalidSnakeException(1, 3);

        assert invalidSnakeException.getMessage().equals("startPosition: 1 should be greater than endPosition: 3");
    }
}
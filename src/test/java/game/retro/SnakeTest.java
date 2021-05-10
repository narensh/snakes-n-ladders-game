package game.retro;

import game.retro.exceptions.InvalidSnakeException;
import org.junit.Test;

public class SnakeTest {

    @Test
    public void testGetStartPosition() {
        Snake snake = Snake.builder().startPosition(10).build();

        assert snake.getStartPosition() == 10;
    }

    @Test
    public void testGetEndPosition() {
        Snake snake = Snake.builder().startPosition(40).endPosition(2).build();

        assert snake.getEndPosition() == 2;
    }

    @Test(expected = InvalidSnakeException.class)
    public void testShouldRaiseErrorWhenStartPositionIsLesserThanEndPosition() {
        try {
            Snake.builder().startPosition(10).endPosition(20).build();
        } catch (InvalidSnakeException e) {
            assert e.getMessage().equals("startPosition: 10 should be greater than endPosition: 20");
            throw e;
        }
    }

    @Test(expected = InvalidSnakeException.class)
    public void testShouldRaiseErrorWhenStartPositionIsSameAsEndPosition() {
        try {
            Snake.builder().startPosition(10).endPosition(10).build();
        } catch (InvalidSnakeException e) {
            assert e.getMessage().equals("startPosition: 10 should be greater than endPosition: 10");
            throw e;
        }
    }
}
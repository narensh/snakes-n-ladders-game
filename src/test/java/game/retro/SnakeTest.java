package game.retro;

import game.retro.exceptions.InvalidSnakeException;
import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.*;

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
        Snake.builder().startPosition(10).endPosition(20).build();
    }
}
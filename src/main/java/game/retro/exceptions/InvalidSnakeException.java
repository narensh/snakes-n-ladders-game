package game.retro.exceptions;

public class InvalidSnakeException extends RuntimeException {
    public InvalidSnakeException(int startPosition, int endPosition) {
        super("startPosition: " + startPosition + " should be greater than endPosition: " + endPosition);
    }
}

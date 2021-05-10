package game.retro.exceptions;

public class PlayerOutOfBoundsException extends RuntimeException {
    public PlayerOutOfBoundsException() {
        super("Player can't go out of bounds of Board");
    }
}

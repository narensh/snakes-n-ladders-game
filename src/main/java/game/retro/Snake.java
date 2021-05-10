package game.retro;

import game.retro.exceptions.InvalidSnakeException;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Snake {
    private int startPosition;
    private int endPosition;

    public Snake(int startPosition, int endPosition) {
        if (startPosition <= endPosition)
            throw new InvalidSnakeException(startPosition, endPosition);

        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    public int bite(int currentPosition) {
        if (getStartPosition() == currentPosition) {
            int newPosition = getEndPosition();
            System.out.println("Ouch!! Snake Bite, moving to position " + newPosition);
            return newPosition;
        }
        return currentPosition;
    }
}
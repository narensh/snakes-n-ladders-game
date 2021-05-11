package game.retro;

import game.retro.exceptions.PlayerOutOfBoundsException;
import lombok.Builder;
import lombok.Getter;

import static java.util.Objects.isNull;

@Getter
public class Board {
    public static final int DEFAULT_SIZE = 100;
    private static final int DEFAULT_PLAYER_POSITION = 0;
    private int size;
    private Player player;
    private int playerPosition;
    private Snake snake;

    @Builder
    public Board(int size, Player player, Snake snake) {
        this.size = size;
        this.player = player;
        this.playerPosition = DEFAULT_PLAYER_POSITION;
        this.snake = snake;
    }

    public void movePlayer(int steps) {
        try {
            int newPlayerPosition = playerPosition + steps;
            validateNewPlayerPosition(newPlayerPosition);

            if (!isNull(snake)) {
                newPlayerPosition = snake.bite(newPlayerPosition);
            }

            showChanges(steps, playerPosition, newPlayerPosition);
            playerPosition = newPlayerPosition;
        } catch (PlayerOutOfBoundsException e) {
            showChanges(steps, playerPosition, playerPosition);
        }
    }

    private void validateNewPlayerPosition(int newPlayerPosition) {
        if (newPlayerPosition > size) {
            throw new PlayerOutOfBoundsException();
        }
    }

    public boolean hasPlayerWon() {
        boolean won = getPlayerPosition() == getSize();
        if (won) {
            System.out.println(player.getName() + " has Won");
        }
        return won;
    }

    private void showChanges(int diceOutcome, int oldPlayerPosition, int newPlayerPosition) {
        StringBuilder stringBuilder = new StringBuilder().append("Dice Outcome: " + diceOutcome)
                .append(" | ").append(player.getName());
        if (oldPlayerPosition != newPlayerPosition) {
            stringBuilder.append(" moved from position " + oldPlayerPosition + " to " + newPlayerPosition);
        } else {
            stringBuilder.append(" didn't move, still at position " + oldPlayerPosition);
        }
        System.out.println(stringBuilder.toString());
    }
}

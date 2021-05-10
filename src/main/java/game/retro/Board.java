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

    public void setPlayerPosition(int newPlayerPosition) {
        validatePlayerPosition(newPlayerPosition);

        if (!isNull(snake)) {
            newPlayerPosition = snake.bite(newPlayerPosition);
        }

        this.playerPosition = newPlayerPosition;
    }

    private void validatePlayerPosition(int newPlayerPosition) {
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
}

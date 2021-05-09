package game.retro;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Board {
    public static final int DEFAULT_SIZE = 100;
    private static final int DEFAULT_PLAYER_POSITION = 0;
    private int size;
    private Player player;
    private int playerPosition;

    @Builder
    public Board(int size, Player player) {
        this.size = size;
        this.player = player;
        this.playerPosition = DEFAULT_PLAYER_POSITION;
    }

    public void setPlayerPosition(int playerPosition) {
        if (playerPosition > size) {
            throw new RuntimeException("Player can't go out of bounds of Board");
        }
        this.playerPosition = playerPosition;
    }

    public boolean hasPlayerWon() {
        boolean won = getPlayerPosition() == getSize();
        if (won) {
            System.out.println(player.getName() + " has Won");
        }
        return won;
    }
}

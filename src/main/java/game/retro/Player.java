package game.retro;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Player {
    private final int STARTING_POSITION = 0;
    private final String name;

    @Builder
    public Player(String name) {
        this.name = name;
    }

    public int throwDice() {
        return Dice.roll();
    }
}
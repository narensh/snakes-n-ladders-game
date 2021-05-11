package game.retro;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Player {
    private final int STARTING_POSITION = 0;
    private final String name;
    private final Dice dice;

    @Builder
    public Player(String name, Dice dice) {
        this.name = name;
        this.dice = dice;
    }

    public int throwDice() {
        return dice.roll();
    }
}
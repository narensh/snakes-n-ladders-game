package game.retro;

import java.util.Random;

public class RegularDice implements Dice {
    public int roll() {
        return new Random().ints(MIN_OUTCOME, MAX_OUTCOME + 1).findFirst().getAsInt();
    }
}

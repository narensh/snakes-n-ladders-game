package game.retro;

import java.util.Random;

public class Dice {
    private static final int MIN_OUTCOME = 1;
    private static final int MAX_OUTCOME = 6;

    public static int roll() {
        return new Random().ints(MIN_OUTCOME, MAX_OUTCOME + 1).findFirst().getAsInt();
    }
}

package game.retro;

import java.util.Random;

public class CrookedDice implements Dice {
    private static final int MIN_OUTCOME = 1;
    private static final int MAX_OUTCOME = 6;

    public int roll() {
        return new Random().ints(MIN_OUTCOME, MAX_OUTCOME + 1)
                .filter(value -> isEvenNumber(value)).findFirst().getAsInt();
    }

    private static boolean isEvenNumber(int num) {
        return num % 2 == 0;
    }
}

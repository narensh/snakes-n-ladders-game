package game.retro;

import game.retro.Dice.Type;

public class DiceBuilder {
    public static Dice getNewDice(Type type) {
        if (type == Type.REGULAR) {
            return new RegularDice();
        } else {
            throw new RuntimeException("Invalid Dice Type selected");
        }
    }
}

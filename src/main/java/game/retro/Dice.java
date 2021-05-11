package game.retro;

public interface Dice {
    static final int MIN_OUTCOME = 1;
    static final int MAX_OUTCOME = 6;

    public enum Type {
        REGULAR,
        CROOKED
    }

    public int roll();
}

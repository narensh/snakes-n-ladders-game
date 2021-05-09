package game.retro;

import lombok.Getter;

@Getter
public class Game {
    private Board board;
    private Player player;
    private int maxTurns;
    private int turnCount;
    private final static int DEFAULT_MAX_TURNS = 30;

    public Game(Board board, Player player, int maxTurns) {
        this.board = board;
        this.player = player;
        this.maxTurns = maxTurns;
    }

    public void start() {
        while (!isCompleted()) {
            ++turnCount;
            playTurn();
        }
    }

    public boolean isCompleted() {
        return board.hasPlayerWon() || turnCount >= maxTurns;
    }

    private void movePlayer(int steps) {
        int oldPlayerPosition = board.getPlayerPosition();
        int newPlayerPosition = oldPlayerPosition + steps;
        if (newPlayerPosition <= board.getSize()) {
            board.setPlayerPosition(newPlayerPosition);
        }
        showTurnInfo(steps, oldPlayerPosition, board.getPlayerPosition());
    }

    private void playTurn() {
        int diceOutcome = player.throwDice();
        movePlayer(diceOutcome);
    }

    private void showTurnInfo(int diceOutcome, int oldPlayerPosition, int newPlayerPosition) {
        StringBuilder stringBuilder = new StringBuilder().append("Turn # " + turnCount)
                .append(" | ").append("Dice Outcome: " + diceOutcome)
                .append(" | ").append(player.getName());
        if (oldPlayerPosition != newPlayerPosition) {
            stringBuilder.append(" moved from position " + oldPlayerPosition + " to " + newPlayerPosition);
        } else {
            stringBuilder.append(" didn't move, still at position " + oldPlayerPosition);
        }
        System.out.println(stringBuilder.toString());
    }

    public static Game buildGame(int boardSize, String playerName, int maxTurns) {
        Player player = Player.builder().name(playerName).build();
        Board board = Board.builder().size(boardSize).player(player).build();

        Game game = new Game(board, player, maxTurns);
        return game;
    }

    public static void main(String... args) {
        Game game = buildGame(Board.DEFAULT_SIZE, "Player A", DEFAULT_MAX_TURNS);
        game.start();
    }
}

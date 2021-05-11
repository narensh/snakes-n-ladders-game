package game.retro;

import lombok.Getter;

@Getter
public class Game {
    private Board board;
    private Player player;
    private int maxTurns;
    private int turnCount;
    private final static int DEFAULT_MAX_TURNS = 30;
    private final static int DEFAULT_SNAKE_START_POS = 20;
    private final static int DEFAULT_SNAKE_END_POS = 10;

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

    private void playTurn() {
        int diceOutcome = player.throwDice();
        board.movePlayer(diceOutcome);
    }

    public static Game buildGame(int boardSize, String playerName, int maxTurns, int snakeStartPos, int snakeEndPos) {
        Player player = Player.builder().name(playerName).build();
        Snake snake = Snake.builder().startPosition(snakeStartPos).endPosition(snakeEndPos).build();
        Board board = Board.builder().size(boardSize).player(player).snake(snake).build();

        Game game = new Game(board, player, maxTurns);
        return game;
    }

    public static void main(String... args) {
        Game game = buildGame(Board.DEFAULT_SIZE, "Player A", DEFAULT_MAX_TURNS,
                DEFAULT_SNAKE_START_POS, DEFAULT_SNAKE_END_POS);
        game.start();
    }
}

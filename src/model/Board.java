package model;

/**
 * Represents a memory board with variable size.
 */
public class Board {

    /**
     * The board itself as a 2d array of GamePiece objects.
     */
    private GamePiece[][] board;
    /**
     * The game's current difficulty.
     */
    private Difficulty difficulty;

    /**
     * Assigns difficulty and generates board depending on it.
     * @param d {@link #difficulty}
     */
    public Board(Difficulty d) {
        this.difficulty = d;

        switch (difficulty) {
            case EASY:
                this.board = BoardGenerator.generateEasyBoard();
                break;
            default:
                this.board = BoardGenerator.generateEasyBoard();
        }
    }

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j].printGamePiece();
            }
        }
    }

    public GamePiece[][] getBoard() {
        return board;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }
}

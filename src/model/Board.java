package model;

/**
 * Represents a memory board with variable size.
 */
public class Board implements BoardInterface{

    /**
     * The board itself as a 2d array of GamePiece objects.
     */
    private GamePiece[][] board;
    /**
     * The game's current difficulty.
     */
    private Difficulty difficulty;
    /**
     * Width of the board.
     */
    private int width;
    /**
     * Height of the board.
     */
    private int height;

    /**
     * Assigns difficulty and generates board depending on it.
     * @param d {@link #difficulty}
     */
    public Board(Difficulty d) {
        this.difficulty = d;

        switch (difficulty) {
            case EASY:
                this.board = BoardGenerator.generateEasyBoard();
                this.width = 2;
                this.height = 3;
                break;
            default:
                this.board = BoardGenerator.generateEasyBoard();
                this.width = 2;
                this.height = 3;
                break;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j].printGamePiece();
            }
        }
    }

    @Override
    public int getBoardWidth() {
        return width;
    }

    @Override
    public int getBoardHeight() {
        return height;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GamePiece getPieceAt(int x, int y) {
        return board[x][y];
    }

    @Override
    public Difficulty getDifficulty() {
        return difficulty;
    }
}

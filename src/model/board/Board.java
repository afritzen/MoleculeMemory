package model.board;

import model.Difficulty;
import model.GamePiece;

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
     * First uncovered piece in a draw.
     */
    private GamePiece uncoveredFst;
    /**
     * Second uncovered piece in a draw.
     */
    private GamePiece uncoveredSnd;
    /**
     * Number of total pairs that can be uncovered during one game.
     */
    private int numPairs;
    /**
     * Pairs that have already been found during the game.
     */
    private int pairsFound;

    /**
     * Assigns difficulty and generates board depending on it.
     * @param d {@link #difficulty}
     */
    public Board(Difficulty d) {
        this.difficulty = d;
        // no pieces uncovered yet, no pairs found
        uncoveredFst = null;
        uncoveredSnd = null;
        pairsFound = 0;

        // adapt board and further values to difficulty
        switch (difficulty) {
            case EASY:
                this.board = BoardGenerator.generateEasyBoard();
                this.width = 2;
                this.height = 3;
                this.numPairs = 3;
                break;
            //TODO: add more difficulties!
            default:
                this.board = BoardGenerator.generateEasyBoard();
                this.width = 2;
                this.height = 3;
                this.numPairs = 3;
                break;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean pairUncovered() {
        return uncoveredFst != null && uncoveredSnd != null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean allUncovered() {
        return pairsFound == numPairs;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean drawNotFinished() {
        return uncoveredFst == null || uncoveredSnd == null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void resetPair() {
        uncoveredFst = null;
        uncoveredSnd = null;
    }

    @Override
    public int getBoardWidth() {
        return width;
    }

    @Override
    public int getBoardHeight() {
        return height;
    }

    @Override
    public GamePiece[][] getBoard() {
        return board;
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

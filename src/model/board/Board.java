package model.board;

import model.GamePiece;
import model.util.Difficulty;

import java.awt.*;
import java.util.HashMap;
import java.util.Observable;

/**
 * Represents a memory board with variable size, consisting of a set of
 * {@link model.GamePiece} objects.
 */
public class Board extends Observable implements BoardInterface {

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
     * Default constructor, not needed in this case since initialization
     * has to occur separately.
     */
    public Board(){}

    @Override
    public void initialize(Difficulty difficulty) {

        this.difficulty = difficulty;
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
        setChanged();
        notifyObservers("start");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean pairMatches() {
        return uncoveredFst.getType() == uncoveredSnd.getType();
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
    public boolean drawFinished() {
        return uncoveredFst != null && uncoveredSnd != null;
    }

    public void resetPair() {
        uncoveredFst = null;
        uncoveredSnd = null;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isPieceAt(int x, int y) {
        if(x > width || y > height) {
            return false;
        }
        return board[x][y] != null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void coverChosen() {
        if(uncoveredFst == null || uncoveredSnd == null) {
            return;
        }
        uncoveredFst.cover();
        uncoveredSnd.cover();
        setChanged();
        notifyObservers(uncoveredFst);
        setChanged();
        notifyObservers(uncoveredSnd);
        resetPair();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setChosen(GamePiece piece) {
        if(uncoveredFst != null) {
            uncoveredSnd = piece;
            uncoveredSnd.uncover();
            setChanged();
            notifyObservers(uncoveredSnd);
        } else {
            uncoveredFst = piece;
            uncoveredFst.uncover();
            setChanged();
            notifyObservers(uncoveredFst);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void incrPairsFound() {
        pairsFound++;
    }

    @Override
    public GamePiece getUncoveredFst() {
        return uncoveredFst;
    }

    @Override
    public GamePiece getUncoveredSnd() {
        return uncoveredSnd;
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

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }
}

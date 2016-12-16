package model.board;

import model.GamePiece;
import model.util.Commands;
import model.util.Constants;
import model.util.Difficulty;

import java.awt.*;
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
    private int boardWidth;
    /**
     * Height of the board.
     */
    private int boardHeight;
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
     * Name of the current player.
     */
    private String playerName;
    /**
     * Used to generate a board depending on {@link #difficulty}.
     */
    private BoardGenerator boardGenerator;

    /**
     * Default constructor, only needed for setting a name and a generator in this case
     * since the complete initialization has to occur separately.
     */
    public Board(){
        playerName = Constants.DEFAULT_PLAYER_NAME;
        boardGenerator = new BoardGenerator();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void load() {
        initialize();
        setChanged();
        notifyObservers(Commands.START_GAME);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initialize() {

        // no pieces uncovered yet, no pairs found
        uncoveredFst = null;
        uncoveredSnd = null;
        pairsFound = 0;

        // set default value in case no options have been applied yet
        if (difficulty == null) {
            difficulty = Difficulty.EASY;
        }

        // adapt board and further values to difficulty
        switch (difficulty) {
            case EASY:
                this.board = boardGenerator.generateEasyBoard();
                this.boardWidth = 2;
                this.boardHeight = 3;
                this.numPairs = 3;
                break;
            //TODO: add more difficulties!
            default:
                this.board = boardGenerator.generateEasyBoard();
                this.boardWidth = 2;
                this.boardHeight = 3;
                this.numPairs = 3;
                break;
        }
        System.out.println(difficulty);
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
        if(x > boardWidth || y > boardHeight) {
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
    public void setNewOptions(Difficulty difficulty, Point size, String playerName) {
        this.boardWidth = size.x;
        this.boardHeight = size.y;
        this.difficulty = difficulty;
        this.playerName = playerName;
        setChanged();
        notifyObservers(Commands.APPLY_OPTIONS);
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
        return boardWidth;
    }

    @Override
    public int getBoardHeight() {
        return boardHeight;
    }

    @Override
    public GamePiece[][] getBoard() {
        return board;
    }

    @Override
    public Difficulty getDifficulty() {
        return difficulty;
    }

    @Override
    public String getPlayerName() {
        return playerName;
    }
}

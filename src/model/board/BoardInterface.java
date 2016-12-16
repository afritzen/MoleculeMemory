package model.board;

import model.util.Difficulty;
import model.GamePiece;

import java.awt.*;

public interface BoardInterface {

    /**
     * Helping method to inform the view about the beginning of a new game.
     */
    void load();

    /**
     * Creates a new board depending on the desired difficulty. Also initializes
     * all needed attributes to a default value.
     */
    void initialize();

    /**
     * Determines whether the two uncovered pieces {@link model.board.Board#uncoveredFst} and
     * {@link model.board.Board#uncoveredSnd} have matching types.
     * @return pairs match?
     */
    boolean pairMatches();

    /**
     * Determines whether all pieces have been uncovered (game ends).
     * @return all pieces uncovered?
     */
    boolean allUncovered();

    /**
     * Determines whether the player still has to uncover a second
     * piece to finish his draw.
     * @return still a piece to uncover?
     */
    boolean drawFinished();

    /**
     * Determines whether there is a piece at the given
     * coordinates.
     * @param x x-coordinate
     * @param y y-coordinate
     * @return piece at position?
     */
    boolean isPieceAt(int x, int y);

    /**
     * Covers both chosen pieces in case they don't match.
     */
    void coverChosen();

    /**
     * Adds a piece to one of the two slots {@link model.board.Board#uncoveredFst}
     * and {@link model.board.Board#uncoveredSnd} to be compared after the draw is
     * finished.
     * @param piece piece to add to empty slot
     */
    void setChosen(GamePiece piece);

    /**
     * Increments {@link model.board.Board#pairsFound} to keep track of
     * all matching pairs found by the player.
     */
    void incrPairsFound();

    /**
     * Assigns new values to the attributes {@link model.board.Board#difficulty},
     * {@link model.board.Board#boardWidth} and {@link model.board.Board#boardHeight}.
     * @param difficulty new difficulty chosen by player
     * @param size new size, represented as a point
     */
    void setNewOptions(Difficulty difficulty, Point size, String playerName);

    String getPlayerName();
    GamePiece getUncoveredFst();
    GamePiece getUncoveredSnd();
    int getBoardWidth();
    int getBoardHeight();
    Difficulty getDifficulty();
    GamePiece[][] getBoard();
}

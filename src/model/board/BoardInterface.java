package model.board;

import model.util.Difficulty;
import model.GamePiece;

public interface BoardInterface {

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
     * Resets {@link model.board.Board#uncoveredFst} and {@link model.board.Board#uncoveredSnd}
     * for a new draw.
     */
    void resetPair();

    /**
     * Determines whether there is a piece at the given
     * coordinates.
     * @param x x-coordinate
     * @param y y-coordinate
     * @return piece at position?
     */
    boolean isPieceAt(int x, int y);

    /**
     * Adds a piece to one of the two slots {@link model.board.Board#uncoveredFst}
     * and {@link model.board.Board#uncoveredSnd} to be compared after the draw is
     * finished.
     * @param piece piece to add to empty slot
     */
    void setChosen(GamePiece piece);

    int getBoardWidth();
    int getBoardHeight();
    GamePiece[][] getBoard();
    Difficulty getDifficulty();


}

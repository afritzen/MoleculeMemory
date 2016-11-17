package model;

public interface BoardInterface {

    /**
     * Returns the piece located at a specific position on the board.
     * @param x the x-coordinate of the piece
     * @param y the y-coordinate of the piece
     * @return the piece itself
     */
    GamePiece getPieceAt(int x, int y);

    /**
     * Determines whether (not more than) two game pieces have been
     * uncovered by the player.
     * @return two pieces uncovered?
     */
    boolean pairUncovered();

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
    boolean drawNotFinished();

    /**
     * Resets {@link #} and {@link} for a new draw.
     */
    void resetPair();

    int getBoardWidth();
    int getBoardHeight();
    Difficulty getDifficulty();


}

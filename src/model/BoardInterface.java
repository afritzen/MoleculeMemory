package model;

public interface BoardInterface {

    int getBoardWidth();
    int getBoardHeight();
    Difficulty getDifficulty();

    /**
     * Returns the piece located at a specific position on the board.
     * @param x the x-ccordinate of the piece
     * @param y the y-coordinate of the piece
     * @return the piece itself
     */
    GamePiece getPieceAt(int x, int y);

    /**
     * Prints the board and it's elements. Used for testing
     * purposes only.
     */
    void printBoard();

}

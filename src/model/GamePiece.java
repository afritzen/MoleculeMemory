package model;

import model.util.PieceType;

/**
 * Class for a single memory game piece on the main board.
 */
public class GamePiece {

    /**
     * X-coordinate on the board.
     */
    private int xPos;
    /**
     * Y-coordinate on the board.
     */
    private int yPos;
    /**
     * The type of molecule the game piece represents.
     */
    private PieceType type;
    /**
     * Determines whether the piece's image is shown.
     */
    private boolean covered;

    /**
     * Constructor holding x- and y-coordinate of the piece.
     * @param x {@link #xPos}
     * @param y {@link #yPos}
     */
    public GamePiece(int x, int y, PieceType t) {
        this.xPos = x;
        this.yPos = y;
        this.type = t;
        covered = true;
    }

    public void uncover() {
        covered = false;
    }

    public void cover() {
        covered = true;
    }

    public boolean isCovered() {
        return covered;
    }

    public PieceType getType() {
        return type;
    }

}

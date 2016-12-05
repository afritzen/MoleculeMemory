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
     * Constructor for a game piece. Every piece holds a type
     * and is covered per default.
     * @param type {@link #type}
     */
    public GamePiece(PieceType type) {
        this.type = type;
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

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }
}

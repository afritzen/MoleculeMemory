package model;

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
     * Determines whether the piece has been uncovered (-> picture is shown).
     */
    private boolean uncovered;
    /**
     * The type of molecule the game piece represents.
     */
    private PieceType type;

    /**
     * Constructor holding x- and y-coordinate of the piece.
     * @param x {@link #xPos}
     * @param y {@link #yPos}
     */
    public GamePiece(int x, int y, PieceType t) {
        this.xPos = x;
        this.yPos = y;
        this.type = t;
    }

    /**
     * Uncovers or covers a piece dependng on current status.
     */
    public void uncover() {
        if (isUncovered()) {
            uncovered = false;
        } else {
            uncovered = true;
        }
    }

    /**
     * Prints a game piece's values.
     */
    public void printGamePiece() {
        System.out.println("xPos: " + xPos + " " + "yPos: " + yPos + "Type: " + type);
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public PieceType getType() {
        return type;
    }

    public boolean isUncovered() {
        return uncovered;
    }
}

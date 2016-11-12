package model;

/**
 * Represents a memory board with variable size.
 */
public class Board {

    private int boardWith;
    private int boardHeight;
    private GamePiece[][] board;

    public Board(int w, int h) {
        this.boardWith = w;
        this.boardHeight = h;
        this.board = createBoard();
    }

    /**
     * Creates a new board consisting of different game pieces.
     * @return the final board
     */
    private GamePiece[][] createBoard() {

        GamePiece[][] board = new GamePiece[boardWith][boardHeight];

        for (int i = 0; i < boardWith; i++) {
            for (int j = 0; j < boardHeight; j++) {
                board[i][j] = new GamePiece(i, j);
            }
        }
        return board;
    }

    /**
     * Prints the board.
     */
    public void printBoard() {
        for(int i = 0; i < boardWith; i++) {
            for (int j = 0; j < boardHeight; j++) {
                board[i][j].printGamePiece();
            }
        }
    }

    public int getBoardWith() {
        return boardWith;
    }

    public void setBoardWith(int boardWith) {
        this.boardWith = boardWith;
    }

    public int getBoardHeight() {
        return boardHeight;
    }

    public void setBoardHeight(int boardHeight) {
        this.boardHeight = boardHeight;
    }
}

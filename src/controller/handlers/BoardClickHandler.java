package controller.handlers;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.GamePiece;
import model.board.Board;
import model.util.Constants;
import view.BoardView;
import view.alerts.GameOverAlert;

/**
 * Custom handler to manage mouse events occurring on the board.
 */
public class BoardClickHandler implements EventHandler<MouseEvent>{

    /**
     * Determines whether the game allows interaction between board and user.
     */
    private boolean active;
    /**
     * @see view.BoardView
     */
    private BoardView boardView;
    /**
     * @see model.board.Board
     */
    private Board board;

    /**
     * Sets up all attributes needed for handling.
     * @param boardView {@link #boardView}
     * @param board {@link #board}
     */
    public BoardClickHandler(BoardView boardView, Board board) {

        this.boardView = boardView;
        this.board = board;
        this.active = true;
    }

    @Override
    public void handle(MouseEvent event) {

        if(!active) {
            // no interaction allowed
            return;
        }

        // get mouse click position relative to piece size
        int eventX = ((int) event.getX()) / Constants.PIECE_SIZE;
        int eventY = ((int) event.getY()) / Constants.PIECE_SIZE;

        if(board.getUncoveredFst() != null && board.getUncoveredSnd() != null) {
            // cover all previously chosen pieces
            board.coverChosen();
        }

        if(board.isPieceAt(eventX, eventY) && !board.drawFinished()) {
            GamePiece selected = board.getBoard()[eventX][eventY];

            if(selected.isCovered()) {
                // uncover piece in model -> update observing view
                selected.uncover();
                board.setChosen(selected);
            }

            if (board.drawFinished()) {

                if(board.pairMatches()) {
                    // TODO: visualize
                    board.incrPairsFound();
                    board.resetPair();
                }

                if(board.allUncovered()) {
                    // no longer allow interaction with the board
                    active = false;
                    GameOverAlert.displayMe(boardView);
                }

            }
        }
    }
}


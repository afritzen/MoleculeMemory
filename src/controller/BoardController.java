package controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.util.Constants;
import model.GamePiece;
import model.board.Board;
import model.util.StandardControllerManager;
import view.BoardViewInterface;
import view.GameOverAlert;
import view.MenuView;

/**
 * Handles all actions on the view.
 */
public class BoardController {

    /**
     * The model, representing a new board.
     */
    private Board board;
    /**
     * Interface for controller-view interaction.
     */
    private BoardViewInterface boardView;
    /**
     * Indicates whether the player is allowed to interact with
     * the board.
     */
    private boolean active;

    /**
     * Assigns handlers to all buttons from the view and connects them to
     * concrete actions.
     * @param board {@link #board}
     * @param boardView {@link #boardView}
     */
    public BoardController(Board board, BoardViewInterface boardView) {
        this.board = board;
        this.boardView = boardView;
        active = true;
        boardView.getBoardGroup().setOnMouseClicked(new BoardClickHandler());

        // assign event handlers to buttons
        boardView.getQuitBtn().setOnAction((event) -> {
            // close game and display main menu
            boardView.getStage().close();
            StandardControllerManager.getMenuController().show();
            event.consume();
        });
    }

    /**
     * Displays the board for a new game.
     */
    public void showBoardView() {
        boardView.showGame();
    }

    /**
     * Inner class handling all mouse clicks occurring on the board itself.
     */
    private class BoardClickHandler implements EventHandler<MouseEvent> {

        public void handle(MouseEvent event) {

            if(!active) {
                return;
            }

            // get mouse click position relative to piece size
            int eventX = ((int) event.getX()) / Constants.PIECE_SIZE;
            int eventY = ((int) event.getY()) / Constants.PIECE_SIZE;

            if(board.getUncoveredFst() != null && board.getUncoveredSnd() != null) {
                boardView.coverPiece(board.getUncoveredFst().getxPos(), board.getUncoveredFst().getyPos());
                boardView.coverPiece(board.getUncoveredSnd().getxPos(), board.getUncoveredSnd().getyPos());
                board.coverChosen();
                board.resetPair();
            }

            if(board.isPieceAt(eventX, eventY) && !board.drawFinished()) {
                GamePiece selected = board.getBoard()[eventX][eventY];

                if(selected.isCovered()) {
                    // uncover piece in model and view
                    selected.uncover();
                    board.setChosen(selected);
                    boardView.uncoverPiece(selected.getxPos(), selected.getyPos());
                }

                if (board.drawFinished()) {

                    if(board.pairMatches()) {
                        board.incrPairsFound();
                        board.resetPair();
                        // TODO: visualize
                        System.out.println("You found a match!");
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

}

package controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.util.Constants;
import model.GamePiece;
import model.board.Board;
import view.BoardViewInterface;
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
     * Assigns handlers to all buttons from the view and connects them to
     * concrete actions.
     * @param board {@link #board}
     * @param boardView {@link #boardView}
     */
    public BoardController(Board board, BoardViewInterface boardView) {
        this.board = board;
        this.boardView = boardView;
        boardView.getBoardGroup().setOnMouseClicked(new BoardClickHandler());

        // assign event handlers to buttons
        boardView.getQuitBtn().setOnAction((event) -> {
            // close game and display main menu
            boardView.getStage().close();
            MenuController menuController = new MenuController(new MenuView());
            menuController.show();
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

            // get mouse click position relative to piece size
            int eventX = ((int) event.getX()) / Constants.PIECE_SIZE;
            int eventY = ((int) event.getY()) / Constants.PIECE_SIZE;

            if(board.isPieceAt(eventX, eventY) && !board.drawFinished()) {
                GamePiece selected = board.getBoard()[eventX][eventY];

                if(selected.isCovered()) {
                    // uncover piece in model and view
                    selected.uncover();
                    board.setChosen(selected);
                    boardView.uncoverPiece(eventX, eventY);
                }

                if (board.drawFinished()) {
                    // short break before second piece is updated
                    try {
                        Thread.sleep(Constants.SLEEP_TIME);
                        //TODO: remove after testing!
                        System.out.println("draw finished!");
                    } catch (InterruptedException ie) {
                        System.out.println("Error! Something went wrong evaluating your draw!");
                    }
                }
            }


        }
    }


}

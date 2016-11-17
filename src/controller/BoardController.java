package controller;

import model.Board;
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


}

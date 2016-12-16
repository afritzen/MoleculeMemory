package controller;

import controller.handlers.BoardClickHandler;
import model.board.Board;
import view.BoardView;
import view.MenuView;
import view.OptionsView;

/**
 * Manages all controllers the application needs to communicate between model and view.
 * Every controller is created here and all necessary observers and listeners are added.
 */
public class MainController {

    private MenuController menuController;
    private OptionsController optionsController;
    private MenuView menuView;
    private OptionsView optionsView;
    private BoardView boardView;
    private Board board;

    /**
     * Initializes all controllers, adds handlers and listeners.
     * @param board board containing the main game logic
     */
    public MainController(Board board) {

        this.board = board;
        menuView = new MenuView();
        optionsView = new OptionsView();
        boardView = new BoardView(board);
        menuController = new MenuController(menuView, board);
        optionsController = new OptionsController(optionsView, board);

        // add all needed observers
        board.addObserver(boardView);
        board.addObserver(optionsView);
        board.addObserver(boardView);

        // assign handlers
        boardView.getBoardGroup().setOnMouseClicked(new BoardClickHandler(boardView, board));

        menuView.getOptionsBtn().setOnAction(event-> {
            optionsView.showOptions();
        });
    }

    public void startGame() {
        menuView.showMainMenu();
    }

}

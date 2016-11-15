package controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import model.Board;
import model.Difficulty;
import view.BoardView;
import view.MenuView;

/**
 * Controller for the main menu view.
 */
public class MenuController {

    private MenuView menuView;

    public MenuController() {
        this.menuView = new MenuView();
        menuView.getStartGameBtn().setOnAction(new StartButtonEventHandler());
    }

    public void show() {
        menuView.showMainMenu();
    }

    class StartButtonEventHandler implements EventHandler {

        @Override
        public void handle(Event event) {
            menuView.getStage().close();
            BoardController boardController = new BoardController(new Board(Difficulty.EASY), new BoardView());
            boardController.showBoardView();
        }
    }

}

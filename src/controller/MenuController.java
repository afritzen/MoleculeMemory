package controller;

import model.board.Board;
import view.MenuViewInterface;

/**
 * Controller for the main menu view. Communication between model and corresponding
 * view is managed here.
 */
public class MenuController {

   public MenuController(MenuViewInterface menuView, Board board) {

        menuView.getStartGameBtn().setOnAction((event) ->{
            // starts a new game and passes update to view via model
            board.initialize();
            board.load();
            event.consume();
        });

        menuView.getQuitGameBtn().setOnAction((event -> {
            // quits the application
            System.exit(0);
        }));
    }
}

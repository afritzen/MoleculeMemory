package controller;

import model.Board;
import model.Difficulty;
import view.MenuViewInterface;
import view.BoardView;

/**
 * Controller for the main menu view.
 */
public class MenuController {

    /**
     * Interface for controller-view interaction.
     */
    private MenuViewInterface menuView;

    /**
     * Assigns handlers to all buttons of the view and connects
     * them to concrete actions.
     * @param menuView {@link #menuView}
     */
    public MenuController(MenuViewInterface menuView) {
        this.menuView = menuView;

        // assign handlers to buttons
        menuView.getStartGameBtn().setOnAction((event) ->{
            // close main menu and start a new game
            menuView.getStage().close();
            Board board = new Board(Difficulty.EASY);
            BoardController boardController = new BoardController(board, new BoardView(board));
            boardController.showBoardView();
            event.consume();
        });

        menuView.getQuitGameBtn().setOnAction((event -> {
            // quits the application
            System.exit(0);
        }));

        menuView.getOptionsBtn().setOnAction(event -> {
            //TODO
        });
    }

    public void show() {
        menuView.showMainMenu();
    }

}

package controller;

import javafx.stage.Stage;
import view.MenuView;

/**
 * Controller for the main menu view.
 */
public class MenuController {

    private MenuView menuView;

    public MenuController() {
        this.menuView = new MenuView();
    }

    public void show() {
        menuView.showMainMenu(menuView.getStage());
    }

}

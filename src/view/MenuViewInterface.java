package view;

import javafx.scene.control.Button;
import javafx.stage.Stage;

public interface MenuViewInterface {

    /**
     * Sets up a new stage and displays the main menu.
     */
    void showMainMenu();

    Button getStartGameBtn();
    Button getQuitGameBtn();
    Button getOptionsBtn();
    Stage getStage();

}

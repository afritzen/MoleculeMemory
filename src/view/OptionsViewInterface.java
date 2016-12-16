package view;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public interface OptionsViewInterface {

    /**
     * Sets up the options view and displays it.
     */
    void showOptions();

    /**
     * Closes the options menu.
     */
    void closeOptions();

    Button getBackBtn();
    Button getApplyBtn();
    TextField getEnterName();
    ToggleGroup getGroupType();
    ToggleGroup getGroupSize();
}

package view;

import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

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
    RadioButton getEasyBtn();
    RadioButton getMediumBtn();
    RadioButton getHardBtn();
    RadioButton getSumBtn();
    RadioButton getLewisBtn();
    RadioButton getBothBtn();
}

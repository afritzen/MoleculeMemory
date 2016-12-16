package controller;

import model.board.Board;
import model.util.Difficulty;
import view.OptionsViewInterface;

import java.awt.*;

public class OptionsController {

    private OptionsViewInterface optionsView;

    public OptionsController(OptionsViewInterface optionsView, Board board) {

        this.optionsView = optionsView;

        //assign event handlers
        optionsView.getApplyBtn().setOnAction(event -> {
            // apply new attributes to model
            board.setNewOptions((Difficulty) optionsView.getGroupSize().getSelectedToggle().getUserData());
            event.consume();
        });

        optionsView.getBackBtn().setOnAction(event -> {
            optionsView.closeOptions();
            event.consume();
        });
    }
}

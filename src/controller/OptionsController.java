package controller;

import model.board.Board;
import view.OptionsViewInterface;

public class OptionsController {

    private OptionsViewInterface optionsView;

    public OptionsController(OptionsViewInterface optionsView, Board board) {
        this.optionsView = optionsView;

        //assign event handlers
        optionsView.getApplyBtn().setOnAction(event -> {
            //TODO: save data
            optionsView.closeOptions();
            event.consume();
        });

        optionsView.getBackBtn().setOnAction(event -> {
            optionsView.closeOptions();
            //TODO: connect to observer pattern
            event.consume();
        });
    }
}

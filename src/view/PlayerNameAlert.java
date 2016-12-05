package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.util.Constants;

/**
 * Represents and displays a small alert box in which the user
 * is prompted to enter his name for the game (needed for highscore).
 */
public class PlayerNameAlert {

    /**
     * Name the player entered, obtained by the alert box.
     */
    private static String playerName;

    /**
     * Displays the alert box consisting of a text field and a button to confirm
     * the player's entry. When the OK-button is clicked, the text field's value
     * is stored to use later in the game (e.g. for a highscore list entry).
     * @return name typed by the player
     */
    public static String displayMe() {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Namen eingeben");
        stage.setWidth(Constants.ALERT_WIDTH);
        stage.setHeight(Constants.ALERT_HEIGHT);

        Label nameLabel = new Label("Name: ");
        TextField nameTextField =  new TextField();
        Button okBtn = new Button("OK");

        okBtn.setOnAction(event -> {
            playerName  = nameTextField.getText();
            stage.close();
        });

        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(nameLabel, nameTextField, okBtn);
        hBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(hBox);
        stage.setScene(scene);
        stage.showAndWait();

        return playerName;

    }
}

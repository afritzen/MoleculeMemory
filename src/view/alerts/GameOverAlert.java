package view.alerts;

import controller.MenuController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.board.Board;
import model.util.Constants;
import model.util.Difficulty;
import view.BoardViewInterface;
import view.MenuView;

/**
 * A simple alert box that contains a text displayed to the user
 * as well as button for returning to the main menu.
 */
public class GameOverAlert {

    /**
     * Creates and displays the alert box.
     * @param boardViewInterface {@link view.BoardViewInterface}
     */
    public static void displayMe(BoardViewInterface boardViewInterface) {

        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Spiel vorbei!");
        stage.setWidth(Constants.ALERT_WIDTH);
        stage.setHeight(Constants.ALERT_HEIGHT);

        Text gameOverTxt = new Text("Alle Paare gefunden!");
        Button backBtn = new Button("Zum Hauptmenü");
        backBtn.setOnAction(event -> {
            stage.close();
            boardViewInterface.getStage().close();
            MenuController menuController = new MenuController(new MenuView(), new Board(Difficulty.EASY));
        });

        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(gameOverTxt, backBtn);
        vBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.showAndWait();

    }

}

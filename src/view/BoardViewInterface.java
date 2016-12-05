package view;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.GamePiece;

public interface BoardViewInterface {

    /**
     * Shows the picture for an uncovered piece.
     * @param x x-coordinate of the piece
     * @param y y-coordinate of the piece
     */
    void uncoverPiece(int x, int y);

    void coverPiece(int x, int y);

    /**
     * Shows a message indicating that the player successfully
     * completed the game.
     */
    void gameCompleteMessage();

    /**
     * Adds a small visual effect to show that two uncovered
     * pieces match.
     */
    void showPairMatch();

    /**
     * Displays the main stage of the game.
     */
    void showGame();

    Button getResetBtn();
    Button getScoreBtn();
    Button getQuitBtn();
    Text getPlayerName();
    Stage getStage();
    Group getBoardGroup();

}

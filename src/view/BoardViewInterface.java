package view;

import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public interface BoardViewInterface {

    /**
     * Shows the picture for an uncovered piece.
     */
    void uncoverPiece();

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

}

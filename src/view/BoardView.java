package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Board;

/**
 * The view for the main game showing the board and a timer.
 */
@SuppressWarnings("FieldCanBeLocal")
public class BoardView {

    private static final int SCENE_WIDHT = 1280;
    private static final int SCENE_HEIGHT = 850;
    private static final int PIECE_SIZE = 75;
    private static final double GRID_WIDHT = 800/10;
    private static final String BOARD_TITLE = "Molecule Memory - Game";

    /**
     * Stage for the scene.
     */
    private Stage stage;
    /**
     * Scene holding the board.
     */
    private Scene scene;
    /**
     * Board as the model.
     */
    private Board board;
    /**
     * Array of all game piece graphics.
     */
    private Rectangle[][] pieceGraphics;
    /**
     * Name of the player, to be displayed in the lower left corner.
     */
    private Text playerName;
    /**
     * Organizes the game's buttons.
     */
    private VBox gameBtns;
    /**
     * Button for resetting the board and score.
     */
    private Button resetBtn;
    /**
     * Button for viewing the current highscore list.
     */
    private Button scoreBtn;
    /**
     * Button for returning to the main menu.
     */
    private Button quitBtn;

    /**
     * Initializes the board and sets up the game scene.
     */
    public BoardView() {

        //main layout
        board = new Board(10, 10);
        pieceGraphics = new Rectangle[board.getBoardWith()][board.getBoardHeight()];
        stage = new Stage();
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setPadding(new Insets(25, 25, 25, 25));
        //gridPane.setGridLinesVisible(true);

        // graphics for the board itself
        Group boardGroup = new Group();
        for(int i = 0; i < board.getBoardWith(); i++) {
            for(int j = 0; j < board.getBoardHeight(); j++) {
                Rectangle piece = new Rectangle(PIECE_SIZE, PIECE_SIZE);
                piece.setTranslateX(i * GRID_WIDHT);
                piece.setTranslateY(j * GRID_WIDHT);
                piece.setFill(Color.LIGHTBLUE);
                piece.setStroke(Color.BLACK);
                boardGroup.getChildren().add(piece);
                pieceGraphics[i][j] = piece;
            }
        }

        gridPane.add(boardGroup, 0, 0);

        playerName = new Text("Player's name");
        playerName.setFont(Font.font("Arial", FontWeight.NORMAL, 20));
        gridPane.add(playerName, 0, 2);

        // organize buttons
        resetBtn = new Button("Reset");
        resetBtn.setPrefWidth(70);
        scoreBtn = new Button("Highscore");
        scoreBtn.setPrefWidth(70);
        quitBtn = new Button("Quit");
        quitBtn.setPrefWidth(70);
        gameBtns = new VBox(10);
        gameBtns.setAlignment(Pos.TOP_RIGHT);
        gameBtns.getChildren().addAll(resetBtn, scoreBtn, quitBtn);
        gridPane.add(gameBtns, 2, 0);

        scene = new Scene(gridPane, SCENE_WIDHT, SCENE_HEIGHT);

    }

    /**
     * Displays the main game.
     */
    public void showGame() {
        stage.setTitle(BOARD_TITLE);
        stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public Button getResetBtn() {
        return resetBtn;
    }

    public Button getScoreBtn() {
        return scoreBtn;
    }

    public Button getQuitBtn() {
        return quitBtn;
    }

    public Text getPlayerName() {
        return playerName;
    }

    public Stage getStage() {
        return stage;
    }
}

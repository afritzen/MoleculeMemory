package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.util.Constants;
import model.util.PieceType;
import model.board.BoardInterface;

/**
 * The view for the main game showing the board and a timer.
 */
@SuppressWarnings("FieldCanBeLocal")
public class BoardView implements BoardViewInterface{

     /**
     * Interface for interaction between model and view
     * (in this case: board logic and board graphics).
     */
    private BoardInterface boardInterface;
    /**
     * Stage for the scene.
     */
    private Stage stage;
    /**
     * Scene holding the board.
     */
    private Scene scene;
    /**
     * Array of all game piece graphics.
     */
    private Group[][] pieceGraphics;
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
     * Group containing the pieces as graphics (= the board itself).
     */
    private Group boardGroup;

    /**
     * Initializes the board and sets up the game scene.
     */
    public BoardView(BoardInterface boardInterface) {

        this.boardInterface = boardInterface;
        //main layout
        pieceGraphics = new Group[boardInterface.getBoardWidth()][boardInterface.getBoardHeight()];
        stage = new Stage();
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setPadding(new Insets(25, 25, 25, 25));
        //gridPane.setGridLinesVisible(true);

        // graphics for the board itself
        boardGroup = new Group();
        for(int i = 0; i < boardInterface.getBoardWidth(); i++) {
            for(int j = 0; j < boardInterface.getBoardHeight(); j++) {
                Group pieceGroup = new Group();
                GamePieceGraphic piece = new GamePieceGraphic(boardInterface.getBoard()[i][j].getType(), i, j);
                GamePieceGraphic cover = new GamePieceGraphic(PieceType.COVERED, i, j);
                pieceGroup.getChildren().addAll(piece, cover);
                pieceGraphics[i][j] = pieceGroup;
                boardGroup.getChildren().add(pieceGroup);
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

        scene = new Scene(gridPane, Constants.SCENE_WIDTH_GAME, Constants.SCENE_HEIGHT_GAME);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showGame() {
        stage.setTitle(Constants.WINDOW_TITLE_BOARD);
        stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void uncoverPiece(int x, int y) {
        if(pieceGraphics[x][y].getChildren().size() == 1) {
            return;
        }
        pieceGraphics[x][y].getChildren().remove(pieceGraphics[x][y].getChildren().size() - 1);
    }

    @Override
    public void coverPiece(int x, int y) {
 /*       if(pieceGraphics[x][y].getChildren().size() > 1) {
            System.out.println("no need to cover");
            return;
        }*/
        pieceGraphics[x][y].getChildren().add(1, new GamePieceGraphic(PieceType.COVERED, x, y));
        System.out.println("covered");
    }

    @Override
    public void gameCompleteMessage() {
        //TODO
    }

    @Override
    public void showPairMatch() {
        //TODO
    }

    @Override
    public Button getResetBtn() {
        return resetBtn;
    }

    @Override
    public Button getScoreBtn() {
        return scoreBtn;
    }

    @Override
    public Button getQuitBtn() {
        return quitBtn;
    }

    @Override
    public Text getPlayerName() {
        return playerName;
    }

    @Override
    public Stage getStage() {
        return stage;
    }

    @Override
    public Group getBoardGroup() {
        return boardGroup;
    }
}

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
import model.GamePiece;
import model.board.BoardInterface;
import model.util.Constants;
import model.util.PieceType;
import java.util.Observable;
import java.util.Observer;

/**
 * The view for the main game showing the board itself and a timer.
 * Since this view implements the Observer interface, it is automatically
 * updated by specific changes in the model (e.g. covering/uncovering a piece).
 */
@SuppressWarnings("FieldCanBeLocal")
public class BoardView implements BoardViewInterface, Observer{

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
     * Initializes important components to be safe, graphics are
     * rendered separately.
     */
    public BoardView(BoardInterface boardInterface) {

        this.boardInterface = boardInterface;
        boardGroup = new Group();
        stage = new Stage();
    }

    @Override
    public void initializeBoardView() {

        //main layout
        pieceGraphics = new Group[boardInterface.getBoardWidth()][boardInterface.getBoardHeight()];
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        // graphics for the board itself
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

    @Override
    public void update(Observable o, Object arg) {

        //TODO: find better solution, e.g. ENUMS!
        if(arg.toString().equals("start")) {
            initializeBoardView();
            showGame();
        } else if (arg instanceof GamePiece) {

            if (!((GamePiece) arg).isCovered()) {
                uncoverPiece(((GamePiece) arg).getxPos(), ((GamePiece) arg).getyPos());
            } else {
                coverPiece(((GamePiece) arg).getxPos(), ((GamePiece) arg).getyPos());
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showGame() {
        stage = new Stage();
        stage.setTitle(Constants.WINDOW_TITLE_BOARD);
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void coverPiece(int x, int y) {
       if(pieceGraphics[x][y].getChildren().size() > 1) {
            return;
        }
        pieceGraphics[x][y].getChildren().add(1, new GamePieceGraphic(PieceType.COVERED, x, y));
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
    public Group getBoardGroup() {
        return boardGroup;
    }

}

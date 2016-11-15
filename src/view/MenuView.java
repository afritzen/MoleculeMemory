package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * The view for the game's main menu. Here the player can configure
 * some options and start the game.
 */
@SuppressWarnings("FieldCanBeLocal")
public class MenuView {

    private static final String MENU_TITLE = "Molecule Memory";
    private static final String WINDOW_TITLE = "Molecule Memory - Main Menu";
    private static final int SCENE_WIDTH = 800;
    private static final int SCENE_HEIGHT = 600;


    private Stage stage;
    /**
     * The scene holding all objects.
     */
    private Scene scene;
    /**
     * The pane holding all buttons and titles.
     */
    private GridPane gridPane;
    /**
     * Organizes all buttons and aligns them.
     */
    private VBox menuBtns;
    /**
     * Button for starting the game.
     */
    private Button startGameBtn;
    /**
     * Button for quitting the game.
     */
    private Button quitGameBtn;
    /**
     * Button for getting into the options-menu.
     */
    private Button optionsBtn;
    /**
     * The game's title, displayed on the scene.
     */
    private Text gameTitle;


    /**
     * Creates a window for the game's main menu containing all options the
     * player has as he starts the application.
     */
    public MenuView() {
        // main layout
        stage = new Stage();
        gridPane = new GridPane();
//        gridPane.setGridLinesVisible(true);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        // title text
        gameTitle = new Text(MENU_TITLE);
        gameTitle.setFont(Font.font("Arial", FontWeight.NORMAL, 35));
        gridPane.add(gameTitle, 2, 0);

        // organize buttons
        startGameBtn = new Button("Start Game");
        startGameBtn.setPrefWidth(150);
        optionsBtn = new Button("Options");
        optionsBtn.setPrefWidth(150);
        quitGameBtn = new Button("Quit");
        quitGameBtn.setPrefWidth(150);
        menuBtns = new VBox(10);
        menuBtns.setAlignment(Pos.CENTER);
        menuBtns.getChildren().addAll(startGameBtn, optionsBtn, quitGameBtn);
        gridPane.add(menuBtns, 2, 3, 2, 1);


        scene = new Scene(gridPane, SCENE_WIDTH, SCENE_HEIGHT);
    }

    /**
     * Sets a stage title and displays the main menu.
     */
    public void showMainMenu() {
        stage.setTitle(WINDOW_TITLE);
        stage.setScene(scene);
        stage.show();
    }

    public Stage getStage() {
        return stage;
    }

    public Button getStartGameBtn() {
        return startGameBtn;
    }

    public Button getQuitGameBtn() {
        return quitGameBtn;
    }

    public Button getOptionsBtn() {
        return optionsBtn;
    }
}
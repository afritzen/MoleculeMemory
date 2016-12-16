package main;

import controller.MainController;
import controller.MenuController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.board.Board;
import model.util.Difficulty;
import view.MenuView;

/**
 * Starting point for the application.
 */
public class MoleculeMemoryMain extends Application {


    /**
     * Sets up a basic scene with no particular pane and a window title.
     * Also instanciates a new {@link controller.MainController} to set up the actual logic.
     * @param primaryStage stage for setting up the scene
     * @throws Exception exception to be thrown if something goes wrong
     */
    @Override
    public void start(Stage primaryStage) throws Exception {

        MainController mainController = new MainController(new Board());
        mainController.startGame();
    }

    /**
     * Main method, only used for launching application itself.
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }
}

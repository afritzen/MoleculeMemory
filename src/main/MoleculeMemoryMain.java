package main;

import controller.MenuController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.Board;
import model.HighscoreList;
import view.MenuView;

/**
 * Starting point for the application.
 */
public class MoleculeMemoryMain extends Application {


    /**
     * Sets up a basic scene with no particular pane and a window title.
     * @param primaryStage stage for setting up the scene
     * @throws Exception exception to be thrown if something goes wrong
     */
    @Override
    public void start(Stage primaryStage) throws Exception {

        MenuController menuController = new MenuController();
        menuController.show();

    }

    /**
     * Main method, only used for launching application itself.
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
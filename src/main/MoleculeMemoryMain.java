package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Starting point for the application.
 */
public class MoleculeMemoryMain extends Application {

    /**
     * Width of the window.
     */
    public static final int WIDTH = 800;
    /**
     * Height of the window.
     */
    public static final int HEIGHT = 600;

    /**
     * Sets up a basic scene with no particular pane and a window title.
     * @param primaryStage stage for setting up the scene
     * @throws Exception exception to be thrown if something goes wrong
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane root = new StackPane();
        primaryStage.setTitle("Molecule Memory");
        primaryStage.setScene(new Scene(root, WIDTH, HEIGHT));
        primaryStage.show();
    }

    /**
     * Main method, only used for launching application itself.
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }
}

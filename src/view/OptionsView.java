package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.util.Commands;
import model.util.Constants;
import model.util.Difficulty;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class OptionsView implements OptionsViewInterface {

    private Stage stage;
    private Scene scene;
    private GridPane gridPane;
    private Button backBtn;
    private Button applyBtn;
    private RadioButton easyBtn;
    private RadioButton mediumBtn;
    private RadioButton hardBtn;
    private RadioButton sumBtn;
    private RadioButton lewisBtn;
    private RadioButton bothBtn;
    private Text optionsHeadlineSize;
    private Text optionsHeadlineType;
    private TextField enterName;
    private final ToggleGroup groupType;
    private final ToggleGroup groupSize;

    /**
     * Provides a simple pane showing two options: difficulty and piece types.
     */
    public OptionsView() {

        // main layout
        stage = new Stage();
        gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        // scene title
        optionsHeadlineSize = new Text("Field size:");
        optionsHeadlineSize.setFont(Font.font("Arial", FontWeight.NORMAL, 20));
        optionsHeadlineType = new Text("Piece types:");
        optionsHeadlineType.setFont(Font.font("Arial", FontWeight.NORMAL, 20));

        easyBtn = new RadioButton("Small");
        easyBtn.setUserData(new Point(2,3));
        mediumBtn = new RadioButton("Medium");
        mediumBtn.setUserData(new Point(10,10));
        hardBtn = new RadioButton("Large");
        hardBtn.setUserData(new Point(20,20));
        sumBtn = new RadioButton("Sum formula");
        sumBtn.setUserData(Difficulty.EASY);
        lewisBtn = new RadioButton("Lewis-Formula");
        lewisBtn.setUserData(Difficulty.MEDIUM);
        bothBtn = new RadioButton("All");
        bothBtn.setUserData(Difficulty.HARD);

        backBtn = new Button("Close");
        applyBtn = new Button("Apply");

        //organize buttons and set toggle groups for radio buttons
        HBox sizeOpt = new HBox(10);
        sizeOpt.getChildren().addAll(easyBtn, mediumBtn, hardBtn);
        groupSize = new ToggleGroup();
        easyBtn.setToggleGroup(groupSize);
        mediumBtn.setToggleGroup(groupSize);
        hardBtn.setToggleGroup(groupSize);
        easyBtn.setSelected(true);

        HBox typeOpt = new HBox(10);
        typeOpt.getChildren().addAll(sumBtn, lewisBtn, bothBtn);
        groupType = new ToggleGroup();
        sumBtn.setToggleGroup(groupType);
        lewisBtn.setToggleGroup(groupType);
        bothBtn.setToggleGroup(groupType);
        lewisBtn.setSelected(true);

        enterName = new TextField();
        enterName.setPromptText("Player name");

        HBox navOpt = new HBox(5);
        navOpt.getChildren().addAll(enterName, backBtn, applyBtn);

        VBox vBox = new VBox(20);
        vBox.getChildren().addAll(optionsHeadlineSize, sizeOpt, optionsHeadlineType, typeOpt, navOpt);
        gridPane.add(vBox, 0, 0);

        scene = new Scene(gridPane, Constants.SCENE_SIZE_OPTIONS, Constants.SCENE_SIZE_OPTIONS);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showOptions() {
        stage.setTitle(Constants.WINDOW_TITLE_OPTIONS);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void closeOptions() {
        stage.close();
    }

    @Override
    public Button getBackBtn() {
        return backBtn;
    }

    @Override
    public Button getApplyBtn() {
        return applyBtn;
    }

    public TextField getEnterName() {
        return enterName;
    }

    @Override
    public ToggleGroup getGroupType() {
        return groupType;
    }

    @Override
    public ToggleGroup getGroupSize() {
        return groupSize;
    }

}

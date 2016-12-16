package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.util.Constants;

import java.util.Observable;
import java.util.Observer;

public class OptionsView implements OptionsViewInterface, Observer{

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
        optionsHeadlineSize = new Text("Feldgröße:");
        optionsHeadlineSize.setFont(Font.font("Arial", FontWeight.NORMAL, 20));
        optionsHeadlineType = new Text("Kartentypen:");
        optionsHeadlineType.setFont(Font.font("Arial", FontWeight.NORMAL, 20));

        easyBtn = new RadioButton("Klein");
        mediumBtn = new RadioButton("Mittel");
        hardBtn = new RadioButton("Groß");
        sumBtn = new RadioButton("Summenformel");
        lewisBtn = new RadioButton("Lewis-Formel");
        bothBtn = new RadioButton("Alles");
        backBtn = new Button("Schließen");
        applyBtn = new Button("Anwenden");

        //organize buttons and set toggle groups for radio buttons
        HBox sizeOpt = new HBox(10);
        sizeOpt.getChildren().addAll(easyBtn, mediumBtn, hardBtn);
        final ToggleGroup groupSize = new ToggleGroup();
        easyBtn.setToggleGroup(groupSize);
        mediumBtn.setToggleGroup(groupSize);
        hardBtn.setToggleGroup(groupSize);
        easyBtn.setSelected(true);

        HBox typeOpt = new HBox(10);
        typeOpt.getChildren().addAll(sumBtn, lewisBtn, bothBtn);
        final ToggleGroup groupType = new ToggleGroup();
        sumBtn.setToggleGroup(groupType);
        lewisBtn.setToggleGroup(groupType);
        bothBtn.setToggleGroup(groupType);
        lewisBtn.setSelected(true);

        HBox navOpt = new HBox(5);
        navOpt.getChildren().addAll(backBtn, applyBtn);

        VBox vBox = new VBox(20);
        vBox.getChildren().addAll(optionsHeadlineSize, sizeOpt, optionsHeadlineType, typeOpt, navOpt);
        gridPane.add(vBox, 0, 0);

        scene = new Scene(gridPane, Constants.SCENE_SIZE_OPTIONS, Constants.SCENE_SIZE_OPTIONS);

    }

    @Override
    public void update(Observable o, Object arg) {
        //TODO
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

    public RadioButton getEasyBtn() {
        return easyBtn;
    }

    public RadioButton getMediumBtn() {
        return mediumBtn;
    }

    public RadioButton getHardBtn() {
        return hardBtn;
    }

    public RadioButton getSumBtn() {
        return sumBtn;
    }

    public RadioButton getLewisBtn() {
        return lewisBtn;
    }

    public RadioButton getBothBtn() {
        return bothBtn;
    }

}

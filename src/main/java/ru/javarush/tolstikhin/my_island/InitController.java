package ru.javarush.tolstikhin.my_island;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import ru.javarush.tolstikhin.my_island.view.windows.MainApplication;

public class InitController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button bk;

    @FXML
    private Button exit;

    @FXML
    private Label nameIsland;

    @FXML
    private ScrollBar scrColor;

    @FXML
    private ScrollPane scrPane;

    @FXML
    private Button start;

    @FXML
    private Button stop;

    private static Stage stage;

    @FXML
    void initialize() {
        bk.setOnAction(this::close);

        exit.setOnAction(event -> {
            Platform.exit();
        });
    }

    public static void setStage(Stage stage) {
        InitController.stage = stage;
    }

    private void close(ActionEvent e) {
        stage.close();
    }
}

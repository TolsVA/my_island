package ru.javarush.tolstikhin.my_island.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import ru.javarush.tolstikhin.my_island.islands.Island;
import ru.javarush.tolstikhin.my_island.models.Presentable;

import java.net.URL;
import java.util.ResourceBundle;

public class InitController {

    @FXML
    public Button generalStatistics;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label bear;

    @FXML
    private Button bk;

    @FXML
    private Label boa;

    @FXML
    private Label boar;

    @FXML
    private Label buffalo;

    @FXML
    private Label caterpillar;

    @FXML
    private Label deer;

    @FXML
    private Label duck;

    @FXML
    private Label eagle;

    @FXML
    private Button exit;

    @FXML
    private Label fox;

    @FXML
    private Label goat;

    @FXML
    private GridPane gridPaneFull;

    @FXML
    private Label horse;

    @FXML
    private Label mouse;

    @FXML
    private Label plant;

    @FXML
    private Label rabbit;

    @FXML
    private ScrollBar scrColor;

    @FXML
    private ScrollPane scrPane;

    @FXML
    private Label sheep;

    @FXML
    private Button start;

    @FXML
    private Button stop;

    @FXML
    private Label wolf;

    private static Stage stage;

    private Presentable model;

    @FXML
    void initialize() {

        bk.setOnAction(this::close);

        exit.setOnAction(event -> {
            System.exit(0);
        });
//        exit.setOnAction(this::close);

        start.setOnAction(event -> {
            model.start();
        });

        stop.setOnAction(event -> {
            model.stop();
        });
    }

    public static void setStage(Stage stage) {
        InitController.stage = stage;
    }

    private void close(ActionEvent e) {
        stage.close();
    }

    public void setModel(Presentable model) {
        this.model = model;
    }
}

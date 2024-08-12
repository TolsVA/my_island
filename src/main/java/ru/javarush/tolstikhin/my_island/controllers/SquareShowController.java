package ru.javarush.tolstikhin.my_island.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SquareShowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label bear;

    @FXML
    private Label boa;

    @FXML
    private Label boar;

    @FXML
    private Label buffalo;

    @FXML
    private Label caterpillar;

    @FXML
    private Label coordinates;

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
    private Label sheep;

    @FXML
    private Label wolf;

    private Stage stage;

    @FXML
    void initialize() {
        exit.setOnAction(e -> stage.close());
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}

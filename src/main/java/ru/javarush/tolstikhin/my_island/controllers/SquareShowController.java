package ru.javarush.tolstikhin.my_island.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SquareShowController {

    @FXML
    private Button exit;

    private Stage stage;

    @FXML
    void initialize() {
        exit.setOnAction(this::close);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    private void close(ActionEvent e) {
        stage.close();
    }
}

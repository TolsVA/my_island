package ru.javarush.tolstikhin.my_island.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import ru.javarush.tolstikhin.my_island.view.ErrorWindow;

import java.net.URL;
import java.util.ResourceBundle;

public class ErrorController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnError;

    @FXML
    private Label textError;

    @FXML
    void initialize() {
        btnError.setOnAction(e -> ErrorWindow.stage.close());
    }
}

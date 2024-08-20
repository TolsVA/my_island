package ru.javarush.tolstikhin.my_island.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class InitController {

    @FXML
    private Button exit;

    @FXML
    void initialize() {
        exit.setOnAction(this::close);
    }

    private void close(ActionEvent e) {
        System.exit(0);
    }
}

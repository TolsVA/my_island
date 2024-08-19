package ru.javarush.tolstikhin.my_island.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.javarush.tolstikhin.my_island.view.ErrorWindow;
import ru.javarush.tolstikhin.my_island.view.InitWindow;

public class MainController {

    private static final String MESSAGE = "Площадь острова должна быть заполнена целыми числами";

    @FXML
    private TextField nameIsland;

    @FXML
    private Button start;

    @FXML
    private Button stop;

    @FXML
    private TextField xPoint;

    @FXML
    private TextField yPoint;

    private Stage stage;

    @FXML
    void initialize() {
        nameIsland.setText("Обитаемый остров");
        xPoint.setText("3");
        yPoint.setText("4");
        start.setOnAction(this::start);
        stop.setOnAction(this::close);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    private boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void close(ActionEvent event) {
        stage.close();
        System.exit(0);
    }

    private void start(ActionEvent event) {
        if (!xPoint.getText().isEmpty() && isNumber(xPoint.getText())
                && !yPoint.getText().isEmpty() && isNumber(yPoint.getText())) {
            try {
                new InitWindow().start(
                        nameIsland.getText(),
                        Double.parseDouble(xPoint.getText()),
                        Double.parseDouble(yPoint.getText())
                );
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            new ErrorWindow().start(MESSAGE);
        }
    }
}

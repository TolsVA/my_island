package ru.javarush.tolstikhin.my_island.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ErrorWindow  {
    public static Stage stage;

    public void start(Stage stage, String message)  {
        ErrorWindow.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(ErrorWindow.class.getResource("error-view.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 650, 70);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Label label = (Label) scene.lookup("#textError");
        label.setText(message);

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.showAndWait();
    }
}

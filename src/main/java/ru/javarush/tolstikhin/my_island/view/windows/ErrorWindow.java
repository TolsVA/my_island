package ru.javarush.tolstikhin.my_island.view.windows;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ru.javarush.tolstikhin.my_island.ErrorController;

public class ErrorWindow {
    public static Stage stage;
    public static void start(Stage stage, String error) throws Exception {
        ErrorWindow.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(ErrorController.class.getResource("error-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 650, 70);

        Label label = (Label) scene.lookup("#textError");
        label.setText(error);

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.showAndWait();
    }
}

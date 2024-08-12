package ru.javarush.tolstikhin.my_island.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ru.javarush.tolstikhin.my_island.Main;
import ru.javarush.tolstikhin.my_island.controllers.InitController;
import ru.javarush.tolstikhin.my_island.controllers.MainController;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        MainController controller = fxmlLoader.getController();
        controller.setStage(stage);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
    }

    public static void run(String[] args) {
        launch(args);
    }
}
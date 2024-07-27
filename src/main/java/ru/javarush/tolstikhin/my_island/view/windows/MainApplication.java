package ru.javarush.tolstikhin.my_island.view.windows;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ru.javarush.tolstikhin.my_island.MainController;
import ru.javarush.tolstikhin.my_island.islands.Island;

public class MainApplication extends Application {

    private Island island;

    private static Stage stage;

    public static Stage getStage() {
        return stage;
    }

    @Override
    public void start(Stage stage) throws Exception {
        MainApplication.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
    }

    public void run(Island island) {
        this.island = island;
        launch();
    }
}
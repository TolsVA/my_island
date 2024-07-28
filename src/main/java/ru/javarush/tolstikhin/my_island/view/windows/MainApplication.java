package ru.javarush.tolstikhin.my_island.view.windows;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ru.javarush.tolstikhin.my_island.InitController;
import ru.javarush.tolstikhin.my_island.MainController;
import ru.javarush.tolstikhin.my_island.app.Viewable;
import ru.javarush.tolstikhin.my_island.islands.Island;

import java.util.List;

public class MainApplication extends Application implements Viewable {


    @Override
    public void start(Stage stage) throws Exception {
//        Application.Parameters params = getParameters();
//        List<String> unnamedParams = getParameters().getUnnamed();
//        System.out.println(unnamedParams.get(0));
        MainController.setStage(stage);
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void run() {
        launch();
    }
}
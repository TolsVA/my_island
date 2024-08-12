package ru.javarush.tolstikhin.my_island.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ru.javarush.tolstikhin.my_island.app.Viewable;
import ru.javarush.tolstikhin.my_island.controllers.InitController;
import ru.javarush.tolstikhin.my_island.models.Presentable;

public class InitWindow implements Viewable {
    public static Presentable model;

    public void start(Stage stage, String name, double x, double y) throws Exception {
//        stage.initStyle(StageStyle.TRANSPARENT);
//        scrollPane.setStyle(String.format("-fx-font-size: %dpx;", (int) (0.4 * 80)));
//        label.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
//        Stage stage = new Stage();

        double width = 800;
        double height = 600;

        InitController.setStage(stage);

        FXMLLoader fxmlLoader = new FXMLLoader(InitWindow.class.getResource("init-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), width, height);
        stage.setTitle(name);

        InitController controller = fxmlLoader.getController();
        controller.setModel(model);

        ScrollPane scrollPane = (ScrollPane) scene.lookup("#scrPane");
        stage.setOnShown(e -> scrollPane.lookup(".viewport").setStyle("-fx-background-color: #bdd0bf;"));

//        Label nameIsland = (Label) scene.lookup("#nameIsland");
//        nameIsland.setText(name);

        GridPane island = model.createIsland((int) x, (int) y, name, scene, controller);

        scrollPane.setContent(island);
        island.setGridLinesVisible(true);

        stage.initModality(Modality.APPLICATION_MODAL);
//        stage.initStyle(StageStyle.UNDECORATED);

        stage.setScene(scene);
        stage.showAndWait();
    }

    @Override
    public void run() {

    }
}

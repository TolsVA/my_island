package ru.javarush.tolstikhin.my_island.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ru.javarush.tolstikhin.my_island.controllers.InitController;
import ru.javarush.tolstikhin.my_island.islands.Island;
import ru.javarush.tolstikhin.my_island.models.Model;
import ru.javarush.tolstikhin.my_island.models.Presentable;

public class InitWindow {
    public void start(String name, double x, double y) throws Exception {
        Stage stage = new Stage();

        double width = 1200;
        double height = 600;

        InitController.setStage(stage);

        FXMLLoader fxmlLoader = new FXMLLoader(InitWindow.class.getResource("init-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), width, height);
        stage.setTitle(name);

        InitController controller = fxmlLoader.getController();

        Presentable model = new Model();
        controller.setModel(model);

        ScrollPane scrollPane = (ScrollPane) scene.lookup("#scrPane");
        stage.setOnShown(event -> scrollPane.lookup(".viewport").setStyle("-fx-background-color: #bdd0bf;"));

        Island island = new Island(x, y);

        AddsElements addsElements = island::add;

        Button generalStatistics = (Button) scene.lookup("#generalStatistics");

        FillsListOrganisms fillsListOrganisms = island::addClassListOrganisms;

        generalStatistics.setOnAction(event -> {
            for (var classListEntry : island.getOrganismFullLinkedHashMap().entrySet()) {
                Label label = (Label) scene.lookup("#" + classListEntry.getKey().getSimpleName().toLowerCase());
                String[] split = label.getText().split(" {2}");
                label.setText(split[0] + "  " + classListEntry.getValue().size());
            }
        });

        model.createIsland(island, (int) x, (int) y, addsElements, scene, fillsListOrganisms);

        scrollPane.setContent(island);
        island.setGridLinesVisible(true);

        stage.initModality(Modality.APPLICATION_MODAL);

        stage.setScene(scene);
        stage.showAndWait();
    }
}

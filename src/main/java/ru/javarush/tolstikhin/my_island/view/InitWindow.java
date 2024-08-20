package ru.javarush.tolstikhin.my_island.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import ru.javarush.tolstikhin.my_island.islands.Island;
import ru.javarush.tolstikhin.my_island.models.Model;
import ru.javarush.tolstikhin.my_island.models.Presentable;

public class InitWindow {
    private Island island;
    private Scene scene;
    private Presentable model;
    private ScrollPane scrollPane;

    public void start(String name, double x, double y) throws Exception {
        island = new Island(x, y);
        Stage stage = new Stage();

        double width = 1200;
        double height = 600;

        FXMLLoader fxmlLoader = new FXMLLoader(InitWindow.class.getResource("init-view.fxml"));

        scene = new Scene(fxmlLoader.load(), width, height);
        stage.setTitle(name);

        model = new Model();

        scrollPane = (ScrollPane) scene.lookup("#scrPane");
        stage.setOnShown(this::setScrollPane);

        AddsElements addsElements = island::add;

        Button start = (Button) scene.lookup("#start");
        start.setOnAction(this::start);

        Button stop = (Button) scene.lookup("#stop");
        stop.setOnAction(this::stop);

        Button generalStatistics = (Button) scene.lookup("#generalStatistics");

        FillsListOrganisms fillsListOrganisms = island::addClassListOrganisms;

        generalStatistics.setOnAction(this::getGeneralStatistics);

        model.createIsland(island, (int) x, (int) y, addsElements, scene, fillsListOrganisms);

        scrollPane.setContent(island);
        island.setGridLinesVisible(true);

        stage.initModality(Modality.APPLICATION_MODAL);

        stage.setScene(scene);
        stage.showAndWait();
    }

    private void start(ActionEvent e){
        model.start();
    }

    private void stop(ActionEvent e){
        model.stop();
    }

    private void getGeneralStatistics(ActionEvent e){
        for (var classListEntry : island.getOrganismFullLinkedHashMap().entrySet()) {
            Label label = (Label) scene.lookup("#" + classListEntry.getKey().getSimpleName().toLowerCase());
            String[] split = label.getText().split(" {2}");
            label.setText(split[0] + "  " + classListEntry.getValue().size());
        }
    }

    private void setScrollPane(WindowEvent event) {
        scrollPane.lookup(".viewport").setStyle("-fx-background-color: #bdd0bf;");
    }
}

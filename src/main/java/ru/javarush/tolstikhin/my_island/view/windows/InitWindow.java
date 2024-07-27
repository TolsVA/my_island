package ru.javarush.tolstikhin.my_island.view.windows;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ru.javarush.tolstikhin.my_island.InitController;

import java.util.ArrayList;
import java.util.List;

public class InitWindow {
    private final List<String> listAnimals = new ArrayList<>(List.of("\uD83D\uDC03", "\uD83D\uDC3B",
            "\uD83D\uDC0E", "\uD83E\uDD8C", "\uD83D\uDC17", "\uD83D\uDC11", "\uD83D\uDC10", "\uD83D\uDC3A",
            "\uD83D\uDC0D", "\uD83E\uDD8A", "\uD83E\uDD85", "\uD83D\uDC07", "\uD83E\uDD86", "\uD83D\uDC01",
            "\uD83D\uDC1B", "\uD83C\uDF3F"));


    public void start(String name, double x, double y) throws Exception {
//        stage.initStyle(StageStyle.TRANSPARENT);
//        scrollPane.setStyle(String.format("-fx-font-size: %dpx;", (int) (0.4 * 80)));
//        label.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));

        double width = 1200;
        double height = 600;
        GridPane gridPane = new GridPane(x, y);
        Stage stage = new Stage();
        InitController.setStage(stage);

        FXMLLoader fxmlLoader = new FXMLLoader(InitController.class.getResource("init-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), width, height);
        ScrollPane scrollPane = (ScrollPane) scene.lookup("#scrPane");
        stage.setOnShown(e -> scrollPane.lookup(".viewport").setStyle("-fx-background-color: #bdd0bf;"));

        Label nameIsland = (Label) scene.lookup("#nameIsland");
        nameIsland.setText(name);

        scrollPane.setContent(gridPane);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                gridPane.add(gridPaneFill(i, j, scene), i, j);
            }
        }

        gridPane.setGridLinesVisible(true);
        stage.setScene(scene);
        stage.showAndWait();
    }

    private Node gridPaneFill(int ii, int jj, Scene scene) {
        GridPane pane = new GridPane(4, 4);
        VBox vBox = new VBox(pane);
//        VBox vBox = new VBox();
//        vBox.getChildren().add(pane);
        vBox.setStyle("-fx-background-color: #14b233;");


        ScrollBar scrollBar = (ScrollBar) scene.lookup("#scrColor");
        scrollBar.setMin(0);
        scrollBar.setMax(10);
        scrollBar.setValue(10);
//        scrollBar.setTranslateX(10);

        scrollBar.valueProperty().addListener(e -> vBox.setOpacity(scrollBar.getValue() / 10));

        pane.setOnMouseClicked(e -> System.out.println("Я ячейка i = " + ii + ", j = " + jj));

        pane.setPadding(new Insets(5));

        int index = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Text text = new Text(listAnimals.get(index));
                text.setStyle("-fx-font: 18 arial;");
                int finalIndex = index;
                text.setOnMouseClicked(e ->
                    System.out.println("Я " + listAnimals.get(finalIndex) + " ячейки i = " + ii + ", j = " + jj)
                );
                text.setFill(Color.WHITE);
                pane.add(text, i, j);
                index++;
            }
        }
        return vBox;
    }
}

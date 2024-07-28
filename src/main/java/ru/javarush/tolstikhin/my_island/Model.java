package ru.javarush.tolstikhin.my_island;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import ru.javarush.tolstikhin.my_island.islands.Island;
import ru.javarush.tolstikhin.my_island.islands.squares.Square;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Model implements Presentable{
    Island island;
    private final List<String> listAnimals = new ArrayList<>(List.of("\uD83D\uDC03", "\uD83D\uDC3B",
            "\uD83D\uDC0E", "\uD83E\uDD8C", "\uD83D\uDC17", "\uD83D\uDC11", "\uD83D\uDC10", "\uD83D\uDC3A",
            "\uD83D\uDC0D", "\uD83E\uDD8A", "\uD83E\uDD85", "\uD83D\uDC07", "\uD83E\uDD86", "\uD83D\uDC01",
            "\uD83D\uDC1B", "\uD83C\uDF3F"));
    @Override
    public Island createIsland(int x, int y, String nameIsland, Scene scene) {
        island = new Island(x, y, nameIsland);
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                island.add(gridPaneFill(i, j, scene, island.getSquares()), i, j);
            }
        }
        return island;
    }

    private VBox gridPaneFill(int x, int y, Scene scene, Square[][] squares) {
        GridPane gridPane = new GridPane(8, 4);
        VBox vBox = new VBox(gridPane);
//        VBox vBox = new VBox();
//        vBox.getChildren().add(pane);
        vBox.setStyle("-fx-background-color: #14b233;");


        ScrollBar scrollBar = (ScrollBar) scene.lookup("#scrColor");
        scrollBar.setMin(0);
        scrollBar.setMax(10);
        scrollBar.setValue(10);
//        scrollBar.setTranslateX(10);

        scrollBar.valueProperty().addListener(e -> vBox.setOpacity(scrollBar.getValue() / 10));

        gridPane.setOnMouseClicked(e -> System.out.println("Я ячейка i = " + x + ", j = " + y));

        gridPane.setPadding(new Insets(5));

        int index = 0;
        for (int i = 0; i < 8; i = i + 2) {
            for (int j = 0; j < 4; j++) {
                Text animalIcon = new Text(listAnimals.get(index));

                animalIcon.setStyle("-fx-font: 18 arial;");
                int finalIndex = index;
                animalIcon.setOnMouseClicked(e ->
                        System.out.println("Я " + listAnimals.get(finalIndex) + " ячейки i = " + x + ", j = " + y)
                );
                animalIcon.setFill(Color.WHITE);
                gridPane.add(animalIcon, i, j);
                Text counterAnimal = new Text(String.valueOf((int) (Math.random() * 30)) + ";");
                gridPane.add(counterAnimal, i + 1, j);
                index++;
            }
        }
        return vBox;
    }
}

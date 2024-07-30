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
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores.Horse;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Model implements Presentable{
    Island island;
    private final List<String> listIconAnimals = new ArrayList<>(List.of("\uD83D\uDC03", "\uD83D\uDC3B",
            "\uD83D\uDC0E", "\uD83E\uDD8C", "\uD83D\uDC17", "\uD83D\uDC11", "\uD83D\uDC10", "\uD83D\uDC3A",
            "\uD83D\uDC0D", "\uD83E\uDD8A", "\uD83E\uDD85", "\uD83D\uDC07", "\uD83E\uDD86", "\uD83D\uDC01",
            "\uD83D\uDC1B", "\uD83C\uDF3F"));

    private final List<String> listNameAnimals = new ArrayList<>(List.of("Buffalo", "Bear", "Horse", "Deer",
            "Boar", "Sheep", "Goat", "Wolf", "Boa", "Fox", "Eagle", "Rabbit", "Duck", "Mouse", "Caterpillar", "Plant"));

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
        GridPane gridPane = new GridPane(4, 4);
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
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Text animalIcon = new Text(listIconAnimals.get(index) + ThreadLocalRandom.current().nextInt(0, 30));

                animalIcon.setStyle("-fx-font: 24 arial;");
                int finalIndex = index;
                animalIcon.setOnMouseClicked(e ->
                        System.out.println("Я " + listIconAnimals.get(finalIndex) + " ячейки i = " + x + ", j = " + y)
                );
                animalIcon.setFill(Color.WHITE);
                gridPane.add(animalIcon, j, i);
//                Text counterAnimal = new Text(String.valueOf((int) (Math.random() * 30)) + ";");
//                gridPane.add(counterAnimal, i, j);
                index++;
            }
        }
        return vBox;
    }
}

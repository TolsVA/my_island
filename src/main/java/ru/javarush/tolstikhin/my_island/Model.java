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
import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Model implements Presentable {
    private Island island;
    private final Map<Class<? extends Organism>, Integer> mapOrganismClassCount;
    private final List<Class<? extends Organism>> listOrganismClass;

    public Model(
            List<Class<? extends Organism>> listOrganismClass,
            Map<Class<? extends Organism>, Integer> mapOrganismClassCount
    ) {
        this.listOrganismClass = listOrganismClass;
        this.mapOrganismClassCount = mapOrganismClassCount;
    }

    @Override
    public GridPane createIsland(int x, int y, String nameIsland, Scene scene) {
        island = new Island(x, y, nameIsland);
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                island.add(gridPaneFill(j, i, scene), i, j);
                gffgfgfgfg(i, j, scene);
            }
        }
        return island;

    }

    @Override
    public void gffgfgfgfg(double x, double y, Scene scene) {
//        Square squares = island.getSquares((int) x, (int) y);
//        int index = 0;
//        for (Map.Entry<Class<? extends Organism>, List<Organism>> classListEntry : squares.getOrganismList().entrySet()) {
//            Text text = (Text) scene.lookup("#f" + index);
//            text.setText(String.valueOf(classListEntry.getValue().size()));
//            index++;
//        }
    }


    private VBox gridPaneFill(int x, int y, Scene scene) {
        Square squareGridPane = new Square(x, y);
        Map<Class<? extends Organism>, List<Organism>> organismList = squareGridPane.getOrganismList();
        VBox vBox = squareGridPane.getVBox();

        ScrollBar scrollBar = (ScrollBar) scene.lookup("#scrColor");
        squareGridPane.setScrollBar(scrollBar);
        squareGridPane.setPadding(new Insets(5));

        GridPane gridPaneFull = (GridPane) scene.lookup("#gridPaneFull");

        int index = 0;
        int count = 0;
        for (int i = 0; i < squareGridPane.getHgap(); i++) {
            for (int j = 0; j < squareGridPane.getVgap(); j++) {
                Class<? extends Organism> aClass = listOrganismClass.get(index);

                count = ThreadLocalRandom.current().nextInt(1, mapOrganismClassCount.get(aClass) + 1);
                List<Organism> listOrganism = new ArrayList<>();
                for (int o = 0; o < count; o++) {
                    try {
                        listOrganism.add(aClass.getDeclaredConstructor().newInstance());
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                             NoSuchMethodException e) {
                        throw new RuntimeException(e);
                    }
                }

                organismList.put(aClass, listOrganism);

                String icon = listOrganism.get(0).getIcon();

                Text animalIcon = new Text(icon + count);

                animalIcon.setStyle("-fx-font: 24 arial;");

                animalIcon.setOnMouseClicked(e ->
                        System.out.println("Я " + icon + " ячейки x = " + x + ", y = " + y)
                );
                animalIcon.setFill(Color.WHITE);
                squareGridPane.add(animalIcon, j, i);
                index++;
            }

        }
        return vBox;
    }
}

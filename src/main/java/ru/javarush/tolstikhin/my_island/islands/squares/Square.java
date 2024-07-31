package ru.javarush.tolstikhin.my_island.islands.squares;

import javafx.scene.control.ScrollBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores.*;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.predators.*;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.plants.Plant;

import java.util.HashMap;
import java.util.Map;

public class Square extends GridPane {
    private int x;
    private int y;
    private VBox vBox;
    private ScrollBar scrollBar;

    private final Map<Class<? extends Organism>, Integer[]> organismList = new HashMap<>();

    public Square(double x, double y) {
        super(4, 4);
        this.x = (int)x;
        this.y = (int)y;
    }

    public Map<Class<? extends Organism>, Integer[]> getOrganismList() {
        return organismList;
    }

    public VBox getVBox() {
        vBox = new VBox(this);
        vBox.setStyle("-fx-background-color: #14b233;");
        return vBox;
    }

    public void setScrollBar(ScrollBar scrollBar) {
        this.scrollBar = scrollBar;
    }

    public ScrollBar getScrollBar() {
        return scrollBar;
    }
}


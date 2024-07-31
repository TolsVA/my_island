package ru.javarush.tolstikhin.my_island.islands.squares;

import javafx.scene.control.ScrollBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Square extends GridPane {
    private int x;
    private int y;
    private VBox vBox;
    private ScrollBar scrollBar;

    private final Map<Class<? extends Organism>, List<Organism>> organismMapList = new HashMap<>();

    public Square(double x, double y) {
        super(4, 4);
        this.x = (int)x;
        this.y = (int)y;
        this.setOnMouseClicked(e -> System.out.println("Я ячейка i = " + this.x + ", j = " + this.y));
    }

    public Map<Class<? extends Organism>, List<Organism>> getOrganismList() {
        return organismMapList;
    }

    public VBox getVBox() {
        vBox = new VBox(this);
        vBox.setStyle("-fx-background-color: #14b233;");
        return vBox;
    }

    public void setScrollBar(ScrollBar scrollBar) {
        this.scrollBar = scrollBar;
        scrollBar.setMin(0);
        scrollBar.setMax(10);
        scrollBar.setValue(10);
//        scrollBar.setTranslateX(10);

        scrollBar.valueProperty().addListener(e -> vBox.setOpacity(scrollBar.getValue() / 10));
    }

    public ScrollBar getScrollBar() {
        return scrollBar;
    }
}


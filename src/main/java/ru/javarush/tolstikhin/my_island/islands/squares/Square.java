package ru.javarush.tolstikhin.my_island.islands.squares;

import javafx.scene.control.ScrollBar;
import javafx.scene.layout.VBox;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Square extends VBox {
    private final int x;
    private final int y;
    private ScrollBar scrollBar;

    private final Map<Class<? extends Organism>, List<Organism>> organismMapList = new LinkedHashMap<>();

    public Square(double x, double y) {
        this.x = (int)x;
        this.y = (int)y;
        this.setStyle("-fx-background-color: #14b233;");
        onClicked();
        this.setPrefSize(50, 50);
    }

    private void onClicked() {
        this.setOnMouseClicked(e -> {
            System.out.println("Я ячейка X = " + this.x + ", y = " + this.y);
            for (List<Organism> values : organismMapList.values()) {
                if (!values.isEmpty()) {
                    String icon = values.getFirst().getIcon();
                    int size = values.size();
                    System.out.println(icon + " - " + size);
                    for (Organism value : values) {
                        System.out.println("\t\t" + value);
                    }
                }
            }
        });
    }

    public Map<Class<? extends Organism>, List<Organism>> getOrganismList() {
        return organismMapList;
    }

//    public VBox getVBox() {
//        vBox = new VBox(this);
//        vBox.setStyle("-fx-background-color: #14b233;");
//        return vBox;
//    }

    public void setScrollBar(ScrollBar scrollBar) {
        this.scrollBar = scrollBar;
        scrollBar.setMin(0);
        scrollBar.setMax(10);
        scrollBar.setValue(10);
//        scrollBar.setTranslateX(10);

        scrollBar.valueProperty().addListener(e -> this.setOpacity(scrollBar.getValue() / 10));
    }

    public ScrollBar getScrollBar() {
        return scrollBar;
    }
}


package ru.javarush.tolstikhin.my_island.islands.squares;

import javafx.scene.control.ScrollBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import ru.javarush.tolstikhin.my_island.view.SquareShowWindow;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Square extends VBox {
    private final int x;
    private final int y;
    private ScrollBar scrollBar;

    private final Map<Class<? extends Organism>, List<Organism>> organismMapList = new LinkedHashMap<>();

    public Square(double x, double y, int count) {
        this.x = (int)x;
        this.y = (int)y;
        this.setStyle("-fx-background-color: #14b233;");
        onClicked();
        this.setPrefSize(count , count);
    }

    private void onClicked() {
        this.setOnMouseClicked(this::newSquareShowWindow);
    }

    private void newSquareShowWindow(MouseEvent e) {
        String nameSquare = String.format("Ячейка:  X = %d, Y = %d", this.x + 1, this.y + 1);
        new SquareShowWindow().start(nameSquare, organismMapList);
    }


    public Map<Class<? extends Organism>, List<Organism>> getOrganismList() {
        return organismMapList;
    }

    public void setScrollBar(ScrollBar scrollBar) {
        this.scrollBar = scrollBar;
        scrollBar.setMin(0);
        scrollBar.setMax(10);
        scrollBar.setValue(10);
        scrollBar.setTranslateX(10);

        scrollBar.valueProperty().addListener(e -> this.setOpacity(scrollBar.getValue() / 10));
    }

    public ScrollBar getScrollBar() {
        return scrollBar;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}


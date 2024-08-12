package ru.javarush.tolstikhin.my_island.islands.squares;

import javafx.scene.control.ScrollBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ru.javarush.tolstikhin.my_island.view.SquareShowWindow;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Square extends VBox {
    private final int x;
    private final int y;
    private ScrollBar scrollBar;
//    private static Map<Class<? extends Organism>, Integer> organismFullLinkedHashMap = new LinkedHashMap<>();

    private Map<Class<? extends Organism>, List<Organism>> organismMapList = new LinkedHashMap<>();

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
        Map<Class<? extends Organism>, Integer> integerMap = new HashMap<>();
        for (Map.Entry<Class<? extends Organism>, List<Organism>> classListEntry : organismMapList.entrySet()) {
            integerMap.put(classListEntry.getKey(),classListEntry.getValue().size());
        }
        new SquareShowWindow().start(nameSquare, integerMap);
    }


    public Map<Class<? extends Organism>, List<Organism>> getOrganismList() {
        return organismMapList;
    }

//    public void setOrganismMapList(Organism organism) {
//        this.organismMapList.get(organism.getClass()).add(organism);
//        organismFullLinkedHashMap.put(organism.getClass(),organismFullLinkedHashMap.get(organism.getClass()) + 1);
//    }

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


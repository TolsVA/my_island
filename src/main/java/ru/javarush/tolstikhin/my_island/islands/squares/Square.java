package ru.javarush.tolstikhin.my_island.islands.squares;

import javafx.scene.layout.GridPane;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;

import java.util.ArrayList;
import java.util.List;

public class Square extends GridPane {
    private int x;
    private int y;

    private List<Organism> organismList = new ArrayList<>();

    public Square(double x, double y) {
        super(x, y);
        this.x = (int)x;
        this.y = (int)y;
    }

    public List<Organism> getResidentList() {
        return organismList;
    }
}

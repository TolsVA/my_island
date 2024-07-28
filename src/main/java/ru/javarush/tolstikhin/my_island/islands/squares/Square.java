package ru.javarush.tolstikhin.my_island.islands.squares;

import javafx.scene.layout.GridPane;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.Resident;

import java.util.ArrayList;
import java.util.List;

public class Square extends GridPane {
    private int x;
    private int y;

    private List<Resident> residentList = new ArrayList<>();

    public Square(double x, double y) {
        super(x, y);
        this.x = (int)x;
        this.y = (int)y;
    }

    public List<Resident> getResidentList() {
        return residentList;
    }
}

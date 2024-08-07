package ru.javarush.tolstikhin.my_island.islands;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import ru.javarush.tolstikhin.my_island.islands.squares.Square;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Island  extends GridPane {
    private final String name;
    private final Square[][] squares;
    private Map<Class<? extends Organism>, Integer> organismFullLinkedHashMap = new LinkedHashMap<>();

    public Island(double x, double y, String name) {
        super(x, y);
        this.name = name;
        this.squares = new Square[(int) x][(int) y];
    }

    @Override
    public void add(Node node, int x, int y) {
        super.add(node, x, y);
        super.setHgap(1);
        super.setVgap(1);
        squares[x][y] = (Square) node;
    }

    public Square getSquares(int x, int y) {
        return squares[x][y];
    }

    public Square[][] getSquares() {
        return squares;
    }


    public String getName() {
        return name;
    }

    public Map<Class<? extends Organism>, Integer> getOrganismFullLinkedHashMap() {
        return organismFullLinkedHashMap;
    }
}

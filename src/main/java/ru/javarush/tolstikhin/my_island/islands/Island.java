package ru.javarush.tolstikhin.my_island.islands;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import ru.javarush.tolstikhin.my_island.islands.squares.Square;

public class Island  extends GridPane {
    private final String name;
    private final Square[][] squares;
    public Island(double x, double y, String name) {
        super(x, y);
        this.name = name;
        this.squares = new Square[(int) x][(int) y];
    }

    @Override
    public void add(Node node, int x, int y) {
        super.add(node, x, y);
        squares[x][y] = new Square(x, y);
    }

    public Square getSquares(int x, int y) {
        return squares[x][y];
    }

    public String getName() {
        return name;
    }
}

package ru.javarush.tolstikhin.my_island.islands;

import ru.javarush.tolstikhin.my_island.islands.squares.Square;

public class Island  {
    private String name;
    private Square[][] squares;

    public Square[][] getSquares() {
        return squares;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void InitSquares(int x, int y) {
        if (squares == null) squares = new Square[x][y];
    }
}

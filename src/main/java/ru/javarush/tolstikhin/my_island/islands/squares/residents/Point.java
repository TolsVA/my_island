package ru.javarush.tolstikhin.my_island.islands.squares.residents;

import java.util.HashMap;
import java.util.Map;

public class Point {
    private int x;
    private int y;
    private Map<Organism, Integer> mapResidents = new HashMap<>();

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Map<Organism, Integer> getMapResidents() {
        return mapResidents;
    }

    public void setMapResidents(Map<Organism, Integer> mapResidents) {
        this.mapResidents = mapResidents;
    }
}

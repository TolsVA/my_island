package ru.javarush.tolstikhin.my_island.islands.squares.residents;

import java.util.HashMap;
import java.util.Map;

public class Point {
    private int x;
    private int y;
    private Map<Resident, Integer> mapResidents = new HashMap<>();

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Map<Resident, Integer> getMapResidents() {
        return mapResidents;
    }

    public void setMapResidents(Map<Resident, Integer> mapResidents) {
        this.mapResidents = mapResidents;
    }
}

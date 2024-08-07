package ru.javarush.tolstikhin.my_island.threads;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;

import java.util.List;
import java.util.Map;

public abstract class Task {
    protected final Map<Class<? extends Organism>, List<Organism>> classListMap;
    protected final int x;
    protected final int y;


    public Task(Map<Class<? extends Organism>, List<Organism>> classListMap, int x, int y) {
        this.classListMap = classListMap;
        this.x = x;
        this.y = y;
    }
}

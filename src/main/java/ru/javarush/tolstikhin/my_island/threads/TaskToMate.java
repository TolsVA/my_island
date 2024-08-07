package ru.javarush.tolstikhin.my_island.threads;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;

import java.util.List;
import java.util.Map;

public class TaskToMate extends Task implements Runnable {


    public TaskToMate(Map<Class<? extends Organism>, List<Organism>> classListMap, int x, int y) {
        super(classListMap, x, y);
    }

    @Override
    public void run() {

    }
}

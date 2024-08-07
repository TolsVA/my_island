package ru.javarush.tolstikhin.my_island.threads;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;

import java.util.List;
import java.util.Map;

public interface MyCallingBack {
    void callingBack(Map<Class<? extends Organism>, List<Organism>> classListMap, int x, int y);
}

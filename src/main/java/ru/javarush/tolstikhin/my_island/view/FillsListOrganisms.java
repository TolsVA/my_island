package ru.javarush.tolstikhin.my_island.view;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;

import java.util.List;

public interface FillsListOrganisms<T> {
    void fillsList(Class<? extends Organism> aClass, List<Organism> organismList);
}

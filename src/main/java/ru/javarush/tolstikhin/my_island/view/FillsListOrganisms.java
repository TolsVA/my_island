package ru.javarush.tolstikhin.my_island.view;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;

public interface FillsListOrganisms {
    void fillsList(Class<? extends Organism> aClass);
}

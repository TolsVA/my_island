package ru.javarush.tolstikhin.my_island.islands;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;

public interface MyCallbackOrganismCount {
    void callingBack(MyInterface method, Organism organism, int count);
}

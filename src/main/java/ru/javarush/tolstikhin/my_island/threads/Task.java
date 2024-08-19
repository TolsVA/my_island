package ru.javarush.tolstikhin.my_island.threads;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;

import java.util.List;
import java.util.Map;

public abstract class Task implements Runnable{
    protected final Map<Class<? extends Organism>, List<Organism>> squareClassListOrganism;
    protected Animal animal;
    protected List<Organism> organisms;

    protected Task(
            Map<Class<? extends Organism>, List<Organism>> squareClassListOrganism,
            Animal animal,
            List<Organism> organisms
    ) {
        this.squareClassListOrganism = squareClassListOrganism;
        this.animal = animal;
        this.organisms = organisms;
    }
}

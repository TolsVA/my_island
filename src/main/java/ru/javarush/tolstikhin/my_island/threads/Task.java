package ru.javarush.tolstikhin.my_island.threads;

import ru.javarush.tolstikhin.my_island.islands.Island;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;

import java.util.List;
import java.util.Map;

public abstract class Task {
    protected final Map<Class<? extends Organism>, List<Organism>> squareClassListOrganism;
    protected Organism organism;
    protected List<Organism> organisms;

    protected Task(
            Map<Class<? extends Organism>, List<Organism>> squareClassListOrganism,
            Organism organism,
            List<Organism> organisms
    ) {
        this.squareClassListOrganism = squareClassListOrganism;
        this.organism = organism;
        this.organisms = organisms;
    }
}

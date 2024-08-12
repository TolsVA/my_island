package ru.javarush.tolstikhin.my_island.threads;

import ru.javarush.tolstikhin.my_island.islands.Island;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;

import java.util.List;
import java.util.Map;

public abstract class Task {
    protected final Map<Class<? extends Organism>, List<Organism>> squareClassListOrganism;
    protected final int x;
    protected final int y;
    protected Organism organism;
    protected List<Organism> organisms;
    protected Island island;

    protected Task(
            Map<Class<? extends Organism>, List<Organism>> squareClassListOrganism,
            int x,
            int y,
            Organism organism,
            List<Organism> organisms,
            Island island
    ) {
        this.squareClassListOrganism = squareClassListOrganism;
        this.x = x;
        this.y = y;
        this.organism = organism;
        this.organisms = organisms;
        this.island = island;
    }
}

package ru.javarush.tolstikhin.my_island.threads;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;

import java.util.List;
import java.util.Map;

public interface MyCallbackTask {
    void callingBack(
            Map<Class<? extends Organism>, List<Organism>> squareClassListOrganism,
            int x,
            int y,
            Organism organism,
            List<Organism> organisms
    );
}

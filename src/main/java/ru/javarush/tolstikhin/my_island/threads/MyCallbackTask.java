package ru.javarush.tolstikhin.my_island.threads;

import ru.javarush.tolstikhin.my_island.islands.squares.Square;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;

import java.util.List;
import java.util.Map;

public interface MyCallbackTask {
    void callingBack(
            Square square, Map<Class<? extends Organism>, List<Organism>> squareClassListOrganism,
            Organism organism,
            List<Organism> organisms
    );
}

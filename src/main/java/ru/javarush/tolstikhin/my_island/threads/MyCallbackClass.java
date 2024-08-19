package ru.javarush.tolstikhin.my_island.threads;

import ru.javarush.tolstikhin.my_island.islands.Island;
import ru.javarush.tolstikhin.my_island.islands.squares.Square;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class MyCallbackClass implements MyCallbackTask {
    private final ExecutorService executorService;
    private final Island island;
    public MyCallbackClass(ExecutorService executorService, Island island) {
        this.executorService = executorService;
        this.island = island;
    }

    @Override
    public void callingBack(
            Square square,
            Map<Class<? extends Organism>, List<Organism>> squareClassListOrganism,
            Organism organism,
            List<Organism> organisms
    ) {
        if (organism instanceof Animal animal && !animal.isFlag()) {
            executorService.execute(new TaskToEat(squareClassListOrganism, animal, organisms, island));                   // задача есть
            executorService.execute(new TaskToDie(squareClassListOrganism, animal, organisms, island));                   // задача умирать от голода
            executorService.execute(new TaskToMate(squareClassListOrganism, animal, organisms));                          // задача размножаться
            executorService.execute(new TaskToChangeLocation(square, squareClassListOrganism, animal, organisms, island));// задача передвигаться
        }
    }
}

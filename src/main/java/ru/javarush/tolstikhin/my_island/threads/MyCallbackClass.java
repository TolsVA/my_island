package ru.javarush.tolstikhin.my_island.threads;

import ru.javarush.tolstikhin.my_island.islands.Island;
import ru.javarush.tolstikhin.my_island.islands.squares.Square;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;

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
        executorService.execute(new TaskToEat(squareClassListOrganism, organism, organisms, island));                    // задача есть или умирать от голода
        executorService.execute(new TaskToMate(squareClassListOrganism, organism, organisms));                           // задача размножаться
        executorService.execute(new TaskToChangeLocation(square, squareClassListOrganism, organism, organisms, island)); // задача передвигаться
    }
}

package ru.javarush.tolstikhin.my_island.threads;

import ru.javarush.tolstikhin.my_island.islands.Island;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class MyCallbackClass implements MyCallbackTask {
    private ExecutorService executorService;
    private Island island;
    public MyCallbackClass(ExecutorService executorService, Island island) {
        this.executorService = executorService;
        this.island = island;
    }

    @Override
    public void callingBack(
            Map<Class<? extends Organism>, List<Organism>> squareClassListOrganism,
            int x,
            int y,
            Organism organism, List<Organism> organisms
    ) {
        executorService.execute(new TaskToEat(squareClassListOrganism, x, y, organism, organisms, island));  // задача есть
        executorService.execute(new TaskToMate(squareClassListOrganism, x, y, organism, organisms, island)); // задача спариваться
    }
    public ExecutorService getExecutorService(){
        return executorService;
    }
}

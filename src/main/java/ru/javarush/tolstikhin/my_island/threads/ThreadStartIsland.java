package ru.javarush.tolstikhin.my_island.threads;

import ru.javarush.tolstikhin.my_island.islands.Island;
import ru.javarush.tolstikhin.my_island.islands.squares.Square;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class ThreadStartIsland implements Runnable {
    private final ExecutorService executorService;
    private final Island island;
    private final Square square;

    public ThreadStartIsland(ExecutorService executorService, Island island, Square square) {
        this.executorService = executorService;
        this.island = island;
        this.square = square;
    }

    @Override
    public void run() {
        Map<Class<? extends Organism>, List<Organism>> squareClassListOrganism = square.getOrganismList();
        for (List<Organism> organisms : squareClassListOrganism.values()) {
            for (int i = 0; i < organisms.size(); i++) {
                if (organisms.get(i) instanceof Animal animal && !animal.isFlag()) {
                    executorService.execute(   // задача есть или умереть от голода
                            new TaskToEat(squareClassListOrganism, animal, organisms, island)
                    );

                    executorService.execute(  // задача размножаться
                            new TaskToMate(squareClassListOrganism, animal, organisms)
                    );

                    executorService.execute(  // задача передвигаться
                            new TaskToChangeLocation(square, squareClassListOrganism, animal, organisms, island)
                    );
                }
            }
        }
    }
}

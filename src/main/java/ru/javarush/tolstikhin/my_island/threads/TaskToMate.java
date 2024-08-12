package ru.javarush.tolstikhin.my_island.threads;

import ru.javarush.tolstikhin.my_island.islands.Island;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public class TaskToMate extends Task implements Runnable {
    public TaskToMate(
            Map<Class<? extends Organism>, List<Organism>> squareClassListOrganism,
            int x,
            int y,
            Organism organism,
            List<Organism> organisms,
            Island island
    ) {
        super(squareClassListOrganism, x, y, organism, organisms, island);
    }

    @Override
    public void run() {
        if (organism instanceof Animal animal && animal.getGender().equals("female")) {
            boolean pairing = false;
            for (int i = 0; i < organisms.size(); i++) {
                if ( organisms.get(i) instanceof Animal aAnimal && aAnimal.getGender().equals("male")
                        && aAnimal.getMaxAmount() < organisms.size()) {
                    pairing = true;
                    break;
                }
            }
            if (pairing) addAnimal(animal);
        }
    }

    private void addAnimal(Animal animal) {
        try {
            organisms.add(animal.getClass().getDeclaredConstructor().newInstance());
            island.countPositions(Integer::sum, animal.getClass(), 1);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}

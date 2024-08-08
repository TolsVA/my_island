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
            for (Organism organism1 : organisms) {
                if (organism1 instanceof Animal animal1 && animal1.getGender().equals("male")) {
                    pairing = true;
                    break;
                }

            }
            addAnimal(animal, pairing);
        }

    }

    private void addAnimal(Animal animal, boolean pairing) {
        if (pairing) {
            try {
                organisms.add(animal.getClass().getDeclaredConstructor().newInstance());
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(organisms.getLast().getIcon());
    }
}

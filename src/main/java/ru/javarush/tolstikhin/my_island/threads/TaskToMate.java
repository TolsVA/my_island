package ru.javarush.tolstikhin.my_island.threads;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public class TaskToMate extends Task {
    public static final Object LOOK = new Object();

    public TaskToMate(
            Map<Class<? extends Organism>, List<Organism>> squareClassListOrganism,
            Organism organism,
            List<Organism> organisms
    ) {
        super(squareClassListOrganism, organism, organisms);
    }

    @Override
    public void run() {
        if (organism instanceof Animal animal && animal.getGender().equals("female")) {
            boolean pairing = false;
            for (int i = 0; i < organisms.size(); i++) {
                if ( organisms.get(i) instanceof Animal aAnimal && aAnimal.getGender().equals("male")
                        && aAnimal.getMaxAmount() > organisms.size()) {
                    pairing = true;
                    break;
                }
            }
            synchronized (LOOK) {
                if (pairing) addAnimal(animal);
            }
        }
    }

    private void addAnimal(Animal animal) {
        try {
            Animal newAnimal = animal.getClass().getDeclaredConstructor().newInstance();
            organisms.add(newAnimal);
            System.out.println(newAnimal.getIcon() + " - родился");
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}

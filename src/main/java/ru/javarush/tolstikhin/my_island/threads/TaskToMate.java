package ru.javarush.tolstikhin.my_island.threads;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;

import java.lang.reflect.InvocationTargetException;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Map;

public class TaskToMate extends Task {

    public TaskToMate(
            Map<Class<? extends Organism>, List<Organism>> squareClassListOrganism,
            Animal animal,
            List<Organism> organisms
    ) {
        super(squareClassListOrganism, animal, organisms);
    }

    @Override
    public void run() {
        if (animal.getGender().equals("female") &&
                !animal.isFlag() &&
                !organisms.isEmpty() &&
                animal.getMaxAmount() > organisms.size()
        ) {
            boolean b = false;
            try {
                for (Organism organism : organisms) {
                    if (organism instanceof Animal aAnimal && aAnimal.getGender().equals("male")) {
                        b = true;
                        break;
                    }
                }
            } catch (ConcurrentModificationException e){
                System.out.println("Не совсем похоже male");
            }
            if (b) {
                try {
                    Animal newAnimal = getAnimal(animal);
                    organisms.add(newAnimal);
                    System.out.println(newAnimal.getIcon() + " - родился");
                } catch (RuntimeException e) {
                    System.out.println("Не случилось");
                }
            }
        }
        animal.setFlag(true);
    }

    private Animal getAnimal(Animal animal) {
        Animal newAnimal;
        try {
            newAnimal = animal.getClass().getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return newAnimal;
    }
}

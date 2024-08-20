package ru.javarush.tolstikhin.my_island.threads;

import ru.javarush.tolstikhin.my_island.islands.Island;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class TaskToEat extends Task {
    public static final Object LOOK = new Object();
    private final Island island;
    private boolean foodAvailability = false;

    public TaskToEat(
            Map<Class<? extends Organism>, List<Organism>> squareClassListOrganism,
            Animal animal,
            List<Organism> organisms,
            Island island
    ) {
        super(squareClassListOrganism, animal, organisms);
        this.island = island;
    }

    @Override
    public void run() {
        if (animal != null && squareClassListOrganism.get(animal.getClass()).contains(animal)) {
            animal.setSatiety(-(animal.getMaxFood() > 0 ? animal.getMaxFood() / 10 : 0));
            if (animal.getSatiety() < animal.getMaxFood()) {
                eatAnimal(animal);
            }
        }
    }

    private void eatAnimal(Animal animal) {
        Map<Class<? extends Organism>, Integer> food = animal.getFood();
        List<Class<? extends Organism>> listEat = new ArrayList<>(food.keySet()); // Создаём лист того что можем есть
        int index = 0;
        while (animal.getSatiety() < animal.getMaxFood() && index < listEat.size()) {
            index = getIndex(animal, listEat, index, food);
        }
        die(animal);
    }

    private int getIndex(
            Animal animal,
            List<Class<? extends Organism>> listEat,
            int index,
            Map<Class<? extends Organism>, Integer> food
    ) {
        Class<? extends Organism> aClassEat = listEat.get(index);
        List<Organism> organismsEat = squareClassListOrganism.get(aClassEat);         // Достаем список по классу
        Integer requiredProbability = food.get(aClassEat);                             // Требуемая вероятность
        int probability = ThreadLocalRandom.current().nextInt(1, 101);    // Вероятность обеда

        synchronized (LOOK) {
            if (probability <= requiredProbability && !organismsEat.isEmpty()) {
                for (int i = 0; i < organismsEat.size(); i++) {
                    if (animal.getSatiety() < animal.getMaxFood()) {
                        if (organismsEat.get(i) != null) {
                            eat(animal, organismsEat.get(i), organismsEat, aClassEat);
                            foodAvailability = true;
                        }
                    } else break;
                }
            } else {
                index++;
            }
        }
        return index;
    }

    private void eat(
            Animal animal,
            Organism organismEat,
            List<Organism> organismsEat,
            Class<? extends Organism> aClassEat
    ) {
        animal.setSatiety(organismEat.getWeight());
        if (organismsEat.remove(organismEat)) {
            island.getOrganismFullLinkedHashMap().get(aClassEat).remove(organismEat);
            System.out.println(organismEat.getIcon() + " - был сьеден");
        }
    }

    private void die(
            Animal animal
    ) {
        if (!foodAvailability) {
            animal.setWeight(-(animal.getMaxFood() > 0 ? animal.getMaxFood() / 10 : 0));
            if (animal.getWeight() <= 0 && organisms.remove(animal)) {
                island.getOrganismFullLinkedHashMap().get(animal.getClass()).remove(animal);
                System.out.println(animal.getIcon() + " - умер от голода");
            }
        }
    }
}
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
                boolean foodAvailability = false;
                eatAnimal(animal, foodAvailability);
            }
        }
    }

    private void eatAnimal(Animal animal, boolean foodAvailability) {
        Map<Class<? extends Organism>, Integer> food = animal.getFood();
        List<Class<? extends Organism>> listEat = new ArrayList<>(food.keySet()); // Создаём лист того что можем есть
        int index = 0;
        while (animal.getSatiety() < animal.getMaxFood() && index < listEat.size()) {
            Class<? extends Organism> aClassEat = listEat.get(                            // Определяем класс рандомно
                    ThreadLocalRandom.current().nextInt(0, listEat.size())
            );
            List<Organism> organismsEat = squareClassListOrganism.get(aClassEat);         // Достаем список по классу
            int probability = ThreadLocalRandom.current().nextInt(1, 101);    // Вероятность обеда
            Integer requiredProbability = food.get(aClassEat);                             // Требуемая вероятность

            synchronized (LOOK) {
                if (!organismsEat.isEmpty()) {
                    Organism organismsEatLast = organismsEat.getLast();
                    if (probability <= requiredProbability && organismsEatLast != null) {
                        eat(animal, organismsEatLast, organismsEat, aClassEat);
                        foodAvailability = true;
                    }
                } else {
                    index++;
                }
            }
        }
        die(foodAvailability, animal);
    }

    private void eat(
            Animal animal,
            Organism organismsEatLast,
            List<Organism> organismsEat,
            Class<? extends Organism> aClassEat
    ) {
        double appetite = animal.getMaxFood() - animal.getSatiety();
        double weight = organismsEatLast.getWeight();
        if (appetite >= weight) {
            animal.setSatiety(weight);
            boolean remove = organismsEat.remove(organismsEatLast);
            if (remove) {
                island.getOrganismFullLinkedHashMap().get(aClassEat).remove(organismsEatLast);
                System.out.println(organismsEatLast.getIcon() + " - был сьеден");
            }
        } else {
            animal.setSatiety(appetite);
            organismsEatLast.setWeight(-appetite);
        }
    }

    private void die(
            boolean foodAvailability,
            Animal animal
    ) {
        if (!foodAvailability) {
            animal.setWeight(-(animal.getMaxFood() > 0 ? animal.getMaxFood() / 10 : 0));
            if (animal.getWeight() <= 0) {
                boolean remove = organisms.remove(animal);
                if (remove) {
                    island.getOrganismFullLinkedHashMap().get(animal.getClass()).remove(animal);
                    System.out.println(animal.getIcon() + " - умер от голода");
                }
            }
        }
    }
}
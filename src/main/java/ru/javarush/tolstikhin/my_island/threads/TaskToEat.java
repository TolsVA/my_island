package ru.javarush.tolstikhin.my_island.threads;

import ru.javarush.tolstikhin.my_island.islands.Island;
import ru.javarush.tolstikhin.my_island.islands.MyInterface;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class TaskToEat extends Task implements Runnable {
    private static final Object LOOK = new Object();

    public TaskToEat(
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
        if (organism != null && squareClassListOrganism.get(organism.getClass()).contains(organism) &&
                organism instanceof Animal animal) {
            animal.setSatiety(-(animal.getMaxFood() > 0 ? animal.getMaxFood() / 10 : 0));
            if (animal.getSatiety() < animal.getMaxFood()) {
                eatAnimal(animal);
            }
        }
    }

    private void eatAnimal(Animal animal) {
        Map<Class<? extends Organism>, Integer> food = animal.getFood();
        List<Class<? extends Organism>> listEat = new ArrayList<>(food.keySet()); // Создаём лист того что можем есть
        boolean foodAvailability = false;
        int index = 0;
        while (animal.getSatiety() < animal.getMaxFood() && index < listEat.size()) {
            Class<? extends Organism> aClassEat = listEat.get(                            // Определяем класс рандомно
                    ThreadLocalRandom.current().nextInt(0, listEat.size())
            );
            List<Organism> organismsEat = squareClassListOrganism.get(aClassEat);     // Достаем список по классу
            int probability = ThreadLocalRandom.current().nextInt(1, 101);    // Вероятность обеда
            Integer requiredProbability = food.get(aClassEat);                            // Требуемая вероятность

            synchronized (LOOK) {
                if (!organismsEat.isEmpty()) {
                    Organism organismsEatLast = organismsEat.getLast();
                    if (probability <= requiredProbability && organismsEatLast != null) {
                        double appetite = animal.getMaxFood() - animal.getSatiety();
                        double weight = organismsEatLast.getWeight();
                        if (appetite >= weight) {
                            animal.setSatiety(weight);
                            organismsEat.remove(organismsEatLast);
                            island.countPositions(
                                    getMethod(),
                                    organismsEatLast.getClass(),
                                    1
                            );
                        } else {
                            animal.setSatiety(appetite);
                            organismsEatLast.setWeight(-appetite);
                        }
                        foodAvailability = true;
                    }
                } else {
                    index++;
                }
            }
        }
        if (!foodAvailability) {
            animal.setWeight(-(animal.getMaxFood() > 0 ? animal.getMaxFood() / 10 : 0));
            if (animal.getWeight() <= 0) organisms.remove(animal);
            island.countPositions(
                    getMethod(),
                    animal.getClass(),
                    1
            );
        }
    }

    private MyInterface getMethod() {
        return (a, b) -> a > b ? a - b : 0;
    }
}

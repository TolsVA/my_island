package ru.javarush.tolstikhin.my_island.threads;

import ru.javarush.tolstikhin.my_island.islands.Island;
import ru.javarush.tolstikhin.my_island.islands.MyInterface;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.plants.Plant;

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
        boolean containsOrganism = squareClassListOrganism.get(organism.getClass()).contains(organism);
        if (containsOrganism) {
            if (organism instanceof Animal animal && animal.getSatiety() > 0) {
                eatAnimal(animal);
            }
        } else {
            System.out.println(organism.getClass().getSimpleName() + " x = " + x + ", y = " + y + "Либо умер либо уго съели");
        }
    }

    private void eatAnimal(Animal animal) {
        Map<Class<? extends Organism>, Integer> food = animal.getFood();
        List<Class<? extends Organism>> listEat = new ArrayList<>(food.keySet()); // Создаём лист того что можем есть
        boolean foodAvailability = false;
        int index = 0;
        while (animal.getSatiety() < animal.getMaxFood() && index < listEat.size()) {
//            Class<? extends Organism> aClassEat = listEat.get(index);                 // Определяем класс по index
            Class<? extends Organism> aClassEat = listEat.get(                        // Определяем класс рандомно
                    ThreadLocalRandom.current().nextInt(0, listEat.size())
            );
            List<Organism> organismsEat = squareClassListOrganism.get(aClassEat);     // Достаем список по классу
            int probability = ThreadLocalRandom.current().nextInt(1, 101);            // Вероятность обеда
            Integer requiredProbability = food.get(aClassEat);                        // Требуемая вероятность

            synchronized (LOOK) {
                if (!organismsEat.isEmpty()) {
                    Organism organismsEatLast = organismsEat.getLast();
                    if (probability <= requiredProbability) {
                        animal.setSatiety(organismsEatLast.getWeight());

                        if (!(organismsEatLast instanceof Plant)) {
                            organismsEat.remove(organismsEatLast);
                            island.countPositions(
                                    getMethod(),
                                    organismsEatLast.getClass(),
                                    1
                            );
                        }

                        foodAvailability = true;
                        System.out.println(
                                animal.getIcon() + " съел - " + organismsEatLast.getIcon() +
                                        " весом " + organismsEatLast.getWeight() +
                                        " ячека x = " + x + ", y = " + y + " " + animal.getIcon() +
                                        " теперь сытость " + animal.getSatiety()
                        );
                    }
                } else {
                    index++;
                }
            }
        }
        if (!foodAvailability) {
            animal.setSatiety(-animal.getMaxFood() / 10);
        }
    }

    private MyInterface getMethod() {
        return (a, b) -> a > b ? a - b : 0;
    }
}

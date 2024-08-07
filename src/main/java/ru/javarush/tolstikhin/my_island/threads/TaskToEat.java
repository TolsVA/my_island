package ru.javarush.tolstikhin.my_island.threads;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.Constants;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class TaskToEat extends Task implements Runnable{
    private Organism eats;
    public TaskToEat(Map<Class<? extends Organism>, List<Organism>> classListMap, int x, int y) {
        super(classListMap, x, y);
    }

    @Override
    public void run() {

        for (List<Organism> organisms : classListMap.values()) {
            for (Organism organism : organisms) {
                if (organism instanceof Animal animal){
                    Map<Class<? extends Organism>, Integer> food = animal.getFood();
                    List<Class<? extends Organism>> listEat = new ArrayList<>(food.keySet());

                    int posEat = ThreadLocalRandom.current().nextInt(0, food.size());
                    Class<? extends Organism> aClassEat = listEat.get(posEat);
                    List<Organism> organismsEat = classListMap.get(aClassEat);
                    if (!organismsEat.isEmpty()){
                        Organism organismsEatLast = organismsEat.getLast();
                        eats = organismsEatLast;
                        int probability = ThreadLocalRandom.current().nextInt(1, 101);

                        Map<Class<? extends Organism>, Integer> classIntegerMap = Constants.animalsMap.get(animal.getClass());
                        Integer probabilityFact = classIntegerMap.get(aClassEat);

                        if (probability <= probabilityFact){
                            animal.eat(organismsEatLast.getWeight());
                            organismsEat.remove(organismsEatLast);
                            System.out.println(animal.getIcon() + " съел - " + organismsEatLast.getIcon() + " ячека x = " + x + ", y = " + y);
                        }
                    } else {
                        System.out.println(animal.getIcon() + " не смог поесть " + eats.getIcon() + " все кончились ячека x = " + x + ", y = " + y);
                        animal.eat(- (animal.getSatiety() / 10));
                    }
                } else {
                    System.out.println(organism.getIcon() + " x = " + x + ", y = " + y);
                }
            }
        }

    }
}

package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;

import java.util.HashMap;
import java.util.Map;

public class Sheep extends Animal {
    public static Map<Class<? extends Organism>, Integer> food = new HashMap<>();
    public Sheep() {
        setName("Овца");
        setIcon("\uD83D\uDC11");
        setMaxWeight(70);
        setMaxAmount(140);
        setMaxSpeed(3);
        setMaxFood(15);
        setSatiety(getMaxFood()/2);
    }
}

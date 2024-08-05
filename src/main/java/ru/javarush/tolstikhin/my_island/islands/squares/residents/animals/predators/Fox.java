package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.predators;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;

import java.util.HashMap;
import java.util.Map;

public class Fox extends Animal {
    public static Map<Class<? extends Organism>, Integer> food = new HashMap<>();
    public Fox() {
        setName("Лиса");
        setIcon("\uD83E\uDD8A");
        setMaxWeight(8);
        setMaxAmount(30);
        setMaxSpeed(2);
        setMaxFood(2);
        setSatiety(getMaxFood()/2);
    }
}

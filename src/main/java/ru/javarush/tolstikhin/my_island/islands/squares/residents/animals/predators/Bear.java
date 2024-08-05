package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.predators;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;

import java.util.HashMap;
import java.util.Map;

public class Bear extends Animal {
    public static Map<Class<? extends Organism>, Integer> food = new HashMap<>();
    public Bear() {
        setName("Медведь");
        setIcon("\uD83D\uDC3B");
        setMaxWeight(500);
        setMaxAmount(5);
        setMaxSpeed(2);
        setMaxFood(80);
        setSatiety(getMaxFood()/2);
    }
}

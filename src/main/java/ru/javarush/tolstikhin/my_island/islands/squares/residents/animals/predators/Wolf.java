package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.predators;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;

import java.util.HashMap;
import java.util.Map;

public class Wolf extends Animal {
    public static Map<Class<? extends Organism>, Integer> food = new HashMap<>();
    public Wolf() {
        setName("Волк");
        setIcon("\uD83D\uDC3A");
        setMaxWeight(50);
        setMaxAmount(30);
        setMaxSpeed(3);
        setMaxFood(8);
        setSatiety(getMaxFood()/2);
    }
}

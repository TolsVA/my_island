package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.predators;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;

import java.util.HashMap;
import java.util.Map;

public class Boa extends Animal {
    public static Map<Class<? extends Organism>, Integer> food = new HashMap<>();
    public Boa() {
        setName("Удав");
        setIcon("\uD83D\uDC0D");
        setMaxWeight(15);
        setMaxAmount(30);
        setMaxSpeed(1);
        setMaxFood(3);
        setSatiety(getMaxFood()/2);
    }
}

package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;

import java.util.HashMap;
import java.util.Map;

public class Goat extends Animal {
    public static Map<Class<? extends Organism>, Integer> food = new HashMap<>();
    public Goat() {
        setName("Коза");
        setIcon("\uD83D\uDC10");
        setMaxWeight(60);
        setMaxAmount(140);
        setMaxSpeed(3);
        setMaxFood(10);
        setSatiety(getMaxFood()/2);
    }
}

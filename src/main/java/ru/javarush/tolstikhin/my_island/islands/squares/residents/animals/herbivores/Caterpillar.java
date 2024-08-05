package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;

import java.util.HashMap;
import java.util.Map;

public class Caterpillar extends Animal {
    public static Map<Class<? extends Organism>, Integer> food = new HashMap<>();
    public Caterpillar() {
        setName("Гусеница");
        setIcon("\uD83D\uDC1B");
        setMaxWeight(0.01);
        setMaxAmount(1000);
        setMaxSpeed(0);
        setMaxFood(0);
        setSatiety(getMaxFood()/2);
    }
}

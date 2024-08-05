package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;

import java.util.HashMap;
import java.util.Map;

public class Duck extends Animal {
    public static Map<Class<? extends Organism>, Integer> food = new HashMap<>();
    public Duck() {
        setName("Утка");
        setIcon("\uD83E\uDD86");
        setMaxWeight(1);
        setMaxAmount(200);
        setMaxSpeed(4);
        setMaxFood(0.15);
        setSatiety(getMaxFood()/2);
    }
}

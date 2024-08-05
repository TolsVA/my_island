package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;

import java.util.HashMap;
import java.util.Map;

public class Deer extends Animal {
    public static Map<Class<? extends Organism>, Integer> food = new HashMap<>();
    public Deer() {
        setName("Олень");
        setIcon("\uD83E\uDD8C");
        setMaxWeight(300);
        setMaxAmount(20);
        setMaxSpeed(4);
        setMaxFood(50);
        setSatiety(getMaxFood()/2);
    }
}

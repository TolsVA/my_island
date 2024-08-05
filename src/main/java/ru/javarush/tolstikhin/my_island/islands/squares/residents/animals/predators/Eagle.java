package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.predators;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;

import java.util.HashMap;
import java.util.Map;

public class Eagle extends Animal {// орёл
    public static Map<Class<? extends Organism>, Integer> food = new HashMap<>();
    public Eagle() {
        setName("Орёл");
        setIcon("\uD83E\uDD85");
        setMaxWeight(6);
        setMaxAmount(20);
        setMaxSpeed(3);
        setMaxFood(1);
        setSatiety(getMaxFood()/2);
    }
}

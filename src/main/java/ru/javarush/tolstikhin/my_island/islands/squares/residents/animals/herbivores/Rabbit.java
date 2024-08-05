package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;

import java.util.HashMap;
import java.util.Map;

public class Rabbit extends Animal {
    public static Map<Class<? extends Organism>, Integer> food = new HashMap<>();
    public Rabbit() {
        setName("Кролик");
        setIcon("\uD83D\uDC07");
        setMaxWeight(2);
        setMaxAmount(150);
        setMaxSpeed(2);
        setMaxFood(0.45);
        setSatiety(getMaxFood()/2);
    }
}

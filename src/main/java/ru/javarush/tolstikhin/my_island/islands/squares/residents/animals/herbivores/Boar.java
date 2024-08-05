package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;

import java.util.HashMap;
import java.util.Map;

public class Boar extends Animal {
    public static Map<Class<? extends Organism>, Integer> food = new HashMap<>();
    public Boar() {
        setName("Кабан");
        setIcon("\uD83D\uDC17");
        setMaxWeight(400);
        setMaxAmount(50);
        setMaxSpeed(2);
        setMaxFood(50);
        setSatiety(getMaxFood()/2);
    }
}

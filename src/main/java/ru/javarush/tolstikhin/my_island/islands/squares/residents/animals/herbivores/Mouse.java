package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;

import java.util.HashMap;
import java.util.Map;

public class Mouse extends Animal {
    public static Map<Class<? extends Organism>, Integer> food = new HashMap<>();
    public Mouse() {
        setName("Мыш");
        setIcon("\uD83D\uDC01");
        setMaxWeight(0.05);
        setMaxAmount(500);
        setMaxSpeed(1);
        setMaxFood(0.01);
        setSatiety(getMaxFood()/2);
    }
}

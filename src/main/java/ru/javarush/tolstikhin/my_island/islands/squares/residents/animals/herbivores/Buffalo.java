package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;

import java.util.HashMap;
import java.util.Map;

public class Buffalo extends Animal {
    public static Map<Class<? extends Organism>, Integer> food = new HashMap<>();
    public Buffalo() {
        setName("Буйвол");
        setIcon("\uD83D\uDC03");
        setMaxWeight(700);
        setMaxAmount(10);
        setMaxSpeed(3);
        setMaxFood(100);
        setSatiety(getMaxFood()/2);
    }
}

package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.EatPlants;

import java.util.ArrayList;
import java.util.List;

public class Rabbit extends Animal implements EatPlants {
    public static final List<Rabbit> LIST_ORGANISM_OF_ONE_TYPE = new ArrayList<>();
    public Rabbit() {
        setName("Кролик");
        setIcon("\uD83D\uDC07");
        setMaxWeight(2);
        setWeight(getMaxWeight() / 2);
        setMaxAmount(150);
        setMaxSpeed(2);
        setMaxFood(0.45);
        setSatiety(getMaxFood()/2);
        LIST_ORGANISM_OF_ONE_TYPE.add(this);
    }
}

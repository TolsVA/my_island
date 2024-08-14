package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.EatPlants;

import java.util.ArrayList;
import java.util.List;

public class Caterpillar extends Animal implements EatPlants {
    public static final List<Caterpillar> LIST_ORGANISM_OF_ONE_TYPE = new ArrayList<>();
    public Caterpillar() {
        setName("Гусеница");
        setIcon("\uD83D\uDC1B");
        setMaxWeight(0.01);
        setWeight(getMaxWeight());
        setMaxAmount(1000);
        setMaxSpeed(0);
        setMaxFood(0);
        setSatiety(0);
        LIST_ORGANISM_OF_ONE_TYPE.add(this);
    }
}

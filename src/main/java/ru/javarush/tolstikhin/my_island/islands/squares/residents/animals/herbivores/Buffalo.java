package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.EatPlants;

import java.util.ArrayList;
import java.util.List;

public class Buffalo extends Animal implements EatPlants {
    public static final List<Buffalo> LIST_ORGANISM_OF_ONE_TYPE = new ArrayList<>();
    public Buffalo() {
        setName("Буйвол");
        setIcon("\uD83D\uDC03");
        setMaxWeight(700);
        setWeight(getMaxWeight() / 2);
        setMaxAmount(10);
        setMaxSpeed(3);
        setMaxFood(100);
        setSatiety(getMaxFood()/2);
        LIST_ORGANISM_OF_ONE_TYPE.add(this);
    }
}

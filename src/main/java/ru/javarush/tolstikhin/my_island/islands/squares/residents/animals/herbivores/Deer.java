package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.EatPlants;

import java.util.ArrayList;
import java.util.List;

public class Deer extends Animal implements EatPlants {
    public static final List<Deer> LIST_ORGANISM_OF_ONE_TYPE = new ArrayList<>();
    public Deer() {
        setName("Олень");
        setIcon("\uD83E\uDD8C");
        setMaxWeight(300);
        setWeight(getMaxWeight() / 2);
        setMaxAmount(20);
        setMaxSpeed(4);
        setMaxFood(50);
        setSatiety(getMaxFood()/2);
        LIST_ORGANISM_OF_ONE_TYPE.add(this);
    }
}

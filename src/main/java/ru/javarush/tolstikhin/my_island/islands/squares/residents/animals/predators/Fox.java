package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.predators;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.CanHunt;

import java.util.ArrayList;
import java.util.List;

public class Fox extends Animal implements CanHunt {
    public static final List<Fox> LIST_ORGANISM_OF_ONE_TYPE = new ArrayList<>();
    public Fox() {
        setName("Лиса");
        setIcon("\uD83E\uDD8A");
        setMaxWeight(8);
        setWeight(getMaxWeight() / 2);
        setMaxAmount(30);
        setMaxSpeed(2);
        setMaxFood(2);
        setSatiety(getMaxFood()/2);
        LIST_ORGANISM_OF_ONE_TYPE.add(this);
    }
}

package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.predators;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.CanHunt;

import java.util.ArrayList;
import java.util.List;

public class Bear extends Animal implements CanHunt {
    public static final List<Bear> LIST_ORGANISM_OF_ONE_TYPE = new ArrayList<>();
    public Bear() {
        setName("Медведь");
        setIcon("\uD83D\uDC3B");
        setMaxWeight(500);
        setWeight(getMaxWeight() / 2);
        setMaxAmount(5);
        setMaxSpeed(2);
        setMaxFood(80);
        setSatiety(getMaxFood() / 2);
        LIST_ORGANISM_OF_ONE_TYPE.add(this);
    }
}

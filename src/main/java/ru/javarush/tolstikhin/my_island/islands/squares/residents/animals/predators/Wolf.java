package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.predators;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.CanHunt;

import java.util.ArrayList;
import java.util.List;

public class Wolf extends Animal implements CanHunt {
    public static final List<Wolf> LIST_ORGANISM_OF_ONE_TYPE = new ArrayList<>();
    public Wolf() {
        setName("Волк");
        setIcon("\uD83D\uDC3A");
        setMaxWeight(50);
        setWeight(getMaxWeight() / 2);
        setMaxAmount(30);
        setMaxSpeed(3);
        setMaxFood(8);
        setSatiety(getMaxFood()/2);
        LIST_ORGANISM_OF_ONE_TYPE.add(this);
    }
}

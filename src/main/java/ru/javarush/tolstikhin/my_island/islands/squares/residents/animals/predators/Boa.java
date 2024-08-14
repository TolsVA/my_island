package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.predators;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.CanHunt;

import java.util.ArrayList;
import java.util.List;

public class Boa extends Animal implements CanHunt {
    public static final List<Boa> LIST_ORGANISM_OF_ONE_TYPE = new ArrayList<>();
    public Boa() {
        setName("Удав");
        setIcon("\uD83D\uDC0D");
        setMaxWeight(15);
        setWeight(getMaxWeight() / 2);
        setMaxAmount(30);
        setMaxSpeed(1);
        setMaxFood(3);
        setSatiety(getMaxFood()/2);
        LIST_ORGANISM_OF_ONE_TYPE.add(this);
    }
}

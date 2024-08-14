package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.predators;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.CanHunt;

import java.util.ArrayList;
import java.util.List;

public class Eagle extends Animal implements CanHunt {// орёл
    public static final List<Eagle> LIST_ORGANISM_OF_ONE_TYPE = new ArrayList<>();
    public Eagle() {
        setName("Орёл");
        setIcon("\uD83E\uDD85");
        setMaxWeight(6);
        setWeight(getMaxWeight() / 2);
        setMaxAmount(20);
        setMaxSpeed(3);
        setMaxFood(1);
        setSatiety(getMaxFood()/2);
        LIST_ORGANISM_OF_ONE_TYPE.add(this);
    }
}

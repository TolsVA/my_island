package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.EatPlants;

import java.util.ArrayList;
import java.util.List;

public class Sheep extends Animal implements EatPlants {
    public static final List<Sheep> LIST_ORGANISM_OF_ONE_TYPE = new ArrayList<>();
    public Sheep() {
        setName("Овца");
        setIcon("\uD83D\uDC11");
        setMaxWeight(70);
        setWeight(getMaxWeight() / 2);
        setMaxAmount(140);
        setMaxSpeed(3);
        setMaxFood(15);
        setSatiety(getMaxFood()/2);
        LIST_ORGANISM_OF_ONE_TYPE.add(this);
    }
}

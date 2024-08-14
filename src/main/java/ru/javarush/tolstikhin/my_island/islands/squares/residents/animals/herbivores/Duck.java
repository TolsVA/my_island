package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.CanHunt;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.EatPlants;

import java.util.ArrayList;
import java.util.List;

public class Duck extends Animal implements EatPlants, CanHunt {
    public static final List<Duck> LIST_ORGANISM_OF_ONE_TYPE = new ArrayList<>();
    public Duck() {
        setName("Утка");
        setIcon("\uD83E\uDD86");
        setMaxWeight(1);
        setWeight(getMaxWeight() / 2);
        setMaxAmount(200);
        setMaxSpeed(4);
        setMaxFood(0.15);
        setSatiety(getMaxFood()/2);
        LIST_ORGANISM_OF_ONE_TYPE.add(this);
    }
}

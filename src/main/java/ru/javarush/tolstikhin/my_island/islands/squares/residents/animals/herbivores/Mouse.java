package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.CanHunt;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.EatPlants;

import java.util.ArrayList;
import java.util.List;

public class Mouse extends Animal implements EatPlants, CanHunt {
    public static final List<Mouse> LIST_ORGANISM_OF_ONE_TYPE = new ArrayList<>();
    public Mouse() {
        setName("Мыш");
        setIcon("\uD83D\uDC01");
        setMaxWeight(0.05);
        setWeight(getMaxWeight() / 2);
        setMaxAmount(500);
        setMaxSpeed(1);
        setMaxFood(0.01);
        setSatiety(getMaxFood()/2);
        LIST_ORGANISM_OF_ONE_TYPE.add(this);
    }
}

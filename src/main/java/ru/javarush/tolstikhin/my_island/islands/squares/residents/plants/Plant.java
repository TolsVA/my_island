package ru.javarush.tolstikhin.my_island.islands.squares.residents.plants;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;

import java.util.ArrayList;
import java.util.List;

public class Plant extends Organism{
    public static final List<Plant> LIST_ORGANISM_OF_ONE_TYPE = new ArrayList<>();
    public Plant() {
        setName("Трава");
        setIcon("\uD83C\uDF3F");
        setMaxWeight(1);
        setWeight(getMaxWeight());
        setMaxAmount(200);
        LIST_ORGANISM_OF_ONE_TYPE.add(this);
    }
}

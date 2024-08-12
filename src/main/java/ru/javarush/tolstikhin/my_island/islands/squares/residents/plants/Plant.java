package ru.javarush.tolstikhin.my_island.islands.squares.residents.plants;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;

public class Plant extends Organism{
    public Plant() {
        setName("Трава");
        setIcon("\uD83C\uDF3F");
        setMaxWeight(1);
        setWeight(getMaxWeight());
        setMaxAmount(200);
    }
}

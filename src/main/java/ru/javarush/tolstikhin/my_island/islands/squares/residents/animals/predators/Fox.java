package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.predators;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;

public class Fox extends Organism {
    public Fox() {
        setName("Лиса");
        setIcon("\uD83E\uDD8A");
        setMaxWeight(8);
        setMaxAmount(30);
        setMaxSpeed(2);
        setMaxFood(2);
    }
}

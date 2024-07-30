package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.predators;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;

public class Bear extends Organism {
    public Bear() {
        setName("Медведь");
        setIcon("\uD83D\uDC3B");
        setMaxWeight(500);
        setMaxAmount(5);
        setMaxSpeed(2);
        setMaxFood(80);
    }
}

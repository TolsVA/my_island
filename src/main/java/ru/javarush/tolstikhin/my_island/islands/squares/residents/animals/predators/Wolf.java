package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.predators;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;

public class Wolf extends Organism {
    public Wolf() {
        setName("Волк");
        setIcon("\uD83D\uDC3A");
        setMaxWeight(50);
        setMaxAmount(30);
        setMaxSpeed(3);
        setMaxFood(8);
    }
}

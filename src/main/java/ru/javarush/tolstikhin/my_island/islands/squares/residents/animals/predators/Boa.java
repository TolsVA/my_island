package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.predators;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;

public class Boa extends Organism {
    public Boa() {
        setName("Удав");
        setIcon("\uD83D\uDC0D");
        setMaxWeight(15);
        setMaxAmount(30);
        setMaxSpeed(1);
        setMaxFood(3);
    }
}

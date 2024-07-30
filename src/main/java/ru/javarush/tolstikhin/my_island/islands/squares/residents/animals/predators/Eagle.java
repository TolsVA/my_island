package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.predators;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;

public class Eagle extends Organism {// орёл
    public Eagle() {
        setName("Орёл");
        setIcon("\uD83E\uDD85");
        setMaxWeight(6);
        setMaxAmount(20);
        setMaxSpeed(3);
        setMaxFood(1);
    }
}

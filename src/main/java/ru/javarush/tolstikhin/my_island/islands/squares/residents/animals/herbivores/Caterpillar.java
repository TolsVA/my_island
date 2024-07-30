package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;

public class Caterpillar extends Organism {
    public Caterpillar() {
        setName("Гусеница");
        setIcon("\uD83D\uDC1B");
        setMaxWeight(0.01);
        setMaxAmount(1000);
        setMaxSpeed(0);
        setMaxFood(0);
    }
}

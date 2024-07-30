package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;

public class Goat extends Organism {
    public Goat() {
        setName("Коза");
        setIcon("\uD83D\uDC10");
        setMaxWeight(60);
        setMaxAmount(140);
        setMaxSpeed(3);
        setMaxFood(10);
    }
}

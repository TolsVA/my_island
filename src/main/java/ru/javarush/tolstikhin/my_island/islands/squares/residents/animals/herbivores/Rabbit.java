package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;

public class Rabbit extends Organism {
    public Rabbit() {
        setName("Кролик");
        setIcon("\uD83D\uDC07");
        setMaxWeight(2);
        setMaxAmount(150);
        setMaxSpeed(2);
        setMaxFood(0.45);
    }
}

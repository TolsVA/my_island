package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;

public class Sheep extends Organism {
    public Sheep() {
        setName("Овца");
        setIcon("\uD83D\uDC11");
        setMaxWeight(70);
        setMaxAmount(140);
        setMaxSpeed(3);
        setMaxFood(15);
    }
}

package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;

public class Duck extends Organism {
    public Duck() {
        setName("Утка");
        setIcon("\uD83E\uDD86");
        setMaxWeight(1);
        setMaxAmount(200);
        setMaxSpeed(4);
        setMaxFood(0.15);
    }
}

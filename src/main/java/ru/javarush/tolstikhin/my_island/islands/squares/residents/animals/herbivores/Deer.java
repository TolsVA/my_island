package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;

public class Deer extends Organism {
    public Deer() {
        setName("Олень");
        setIcon("\uD83E\uDD8C");
        setMaxWeight(300);
        setMaxAmount(20);
        setMaxSpeed(4);
        setMaxFood(50);
    }
}

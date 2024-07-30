package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;

public class Boar extends Organism {
    public Boar() {
        setName("Кабан");
        setIcon("\uD83D\uDC17");
        setMaxWeight(400);
        setMaxAmount(50);
        setMaxSpeed(2);
        setMaxFood(50);
    }
}

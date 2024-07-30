package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;

public class Mouse extends Organism {
    public Mouse() {
        setName("Мыш");
        setIcon("\uD83D\uDC01");
        setMaxWeight(0.05);
        setMaxAmount(500);
        setMaxSpeed(1);
        setMaxFood(0.01);
    }
}

package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;

public class Buffalo extends Organism {
    public Buffalo() {
        setName("Буйвол");
        setIcon("\uD83D\uDC03");
        setMaxWeight(700);
        setMaxAmount(10);
        setMaxSpeed(3);
        setMaxFood(100);
    }
}

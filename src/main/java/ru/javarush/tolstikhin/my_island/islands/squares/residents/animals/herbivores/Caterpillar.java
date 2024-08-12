package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.EatPlants;

public class Caterpillar extends Animal implements EatPlants {
    public Caterpillar() {
        setName("Гусеница");
        setIcon("\uD83D\uDC1B");
        setMaxWeight(0.01);
        setWeight(getMaxWeight());
        setMaxAmount(1000);
        setMaxSpeed(0);
        setMaxFood(0);
        setSatiety(0);
    }
}

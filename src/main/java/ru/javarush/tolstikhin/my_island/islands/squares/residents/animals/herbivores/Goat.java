package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.EatPlants;

public class Goat extends Animal implements EatPlants {
    public Goat() {
        setName("Коза");
        setIcon("\uD83D\uDC10");
        setMaxWeight(60);
        setWeight(getMaxWeight() / 2);
        setMaxAmount(140);
        setMaxSpeed(3);
        setMaxFood(10);
        setSatiety(getMaxFood()/2);
    }
}

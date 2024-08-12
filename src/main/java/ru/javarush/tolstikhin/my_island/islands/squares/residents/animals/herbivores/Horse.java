package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.EatPlants;

public class Horse extends Animal implements EatPlants {
    public Horse() {
        setName("Лошадь");
        setIcon("\uD83D\uDC0E");
        setMaxWeight(400);
        setWeight(getMaxWeight() / 2);
        setMaxAmount(20);
        setMaxSpeed(4);
        setMaxFood(60);
        setSatiety(getMaxFood()/2);
    }
}
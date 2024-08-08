package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.EatPlants;

public class Rabbit extends Animal implements EatPlants {
    public Rabbit() {
        setName("Кролик");
        setIcon("\uD83D\uDC07");
        setMaxWeight(2);
        setWeight(getMaxWeight() / 2);
        setMaxAmount(150);
        setMaxSpeed(2);
        setMaxFood(0.45);
        setSatiety(getMaxFood()/2);
    }
}

package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.EatPlants;

public class Sheep extends Animal implements EatPlants {
    public Sheep() {
        setName("Овца");
        setIcon("\uD83D\uDC11");
        setMaxWeight(70);
        setWeight(getMaxWeight() / 2);
        setMaxAmount(140);
        setMaxSpeed(3);
        setMaxFood(15);
        setSatiety(getMaxFood()/2);
    }
}

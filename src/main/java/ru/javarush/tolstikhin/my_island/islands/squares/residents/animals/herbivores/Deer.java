package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.EatPlants;

public class Deer extends Animal implements EatPlants {
    public Deer() {
        setName("Олень");
        setIcon("\uD83E\uDD8C");
        setMaxWeight(300);
        setWeight(getMaxWeight() / 2);
        setMaxAmount(20);
        setMaxSpeed(4);
        setMaxFood(50);
        setSatiety(getMaxFood()/2);
    }
}

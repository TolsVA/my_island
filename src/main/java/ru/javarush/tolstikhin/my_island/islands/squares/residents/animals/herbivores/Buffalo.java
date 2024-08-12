package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.EatPlants;

public class Buffalo extends Animal implements EatPlants {
    public Buffalo() {
        setName("Буйвол");
        setIcon("\uD83D\uDC03");
        setMaxWeight(700);
        setWeight(getMaxWeight() / 2);
        setMaxAmount(10);
        setMaxSpeed(3);
        setMaxFood(100);
        setSatiety(getMaxFood()/2);
    }
}

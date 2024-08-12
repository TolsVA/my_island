package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.predators;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.CanHunt;

public class Wolf extends Animal implements CanHunt {
    public Wolf() {
        setName("Волк");
        setIcon("\uD83D\uDC3A");
        setMaxWeight(50);
        setWeight(getMaxWeight() / 2);
        setMaxAmount(30);
        setMaxSpeed(3);
        setMaxFood(8);
        setSatiety(getMaxFood()/2);
    }
}

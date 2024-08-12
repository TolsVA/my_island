package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.predators;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.CanHunt;

public class Bear extends Animal implements CanHunt {
    public Bear() {
        setName("Медведь");
        setIcon("\uD83D\uDC3B");
        setMaxWeight(500);
        setWeight(getMaxWeight() / 2);
        setMaxAmount(5);
        setMaxSpeed(2);
        setMaxFood(80);
        setSatiety(getMaxFood() / 2);
    }
}

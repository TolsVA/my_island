package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.predators;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.CanHunt;

public class Fox extends Animal implements CanHunt {
    public Fox() {
        setName("Лиса");
        setIcon("\uD83E\uDD8A");
        setMaxWeight(8);
        setWeight(getMaxWeight() / 2);
        setMaxAmount(30);
        setMaxSpeed(2);
        setMaxFood(2);
        setSatiety(getMaxFood()/2);
    }
}

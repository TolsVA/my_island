package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.predators;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.CanHunt;

public class Boa extends Animal implements CanHunt {
    public Boa() {
        setName("Удав");
        setIcon("\uD83D\uDC0D");
        setMaxWeight(15);
        setWeight(getMaxWeight() / 2);
        setMaxAmount(30);
        setMaxSpeed(1);
        setMaxFood(3);
        setSatiety(getMaxFood()/2);
    }
}

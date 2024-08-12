package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.predators;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.CanHunt;

public class Eagle extends Animal implements CanHunt {// орёл
    public Eagle() {
        setName("Орёл");
        setIcon("\uD83E\uDD85");
        setMaxWeight(6);
        setWeight(getMaxWeight() / 2);
        setMaxAmount(20);
        setMaxSpeed(3);
        setMaxFood(1);
        setSatiety(getMaxFood()/2);
    }
}

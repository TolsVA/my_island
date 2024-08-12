package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.CanHunt;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.EatPlants;

public class Boar extends Animal implements EatPlants, CanHunt {
    public Boar() {
        setName("Кабан");
        setIcon("\uD83D\uDC17");
        setMaxWeight(400);
        setWeight(getMaxWeight() / 2);
        setMaxAmount(50);
        setMaxSpeed(2);
        setMaxFood(50);
        setSatiety(getMaxFood()/2);
    }
}

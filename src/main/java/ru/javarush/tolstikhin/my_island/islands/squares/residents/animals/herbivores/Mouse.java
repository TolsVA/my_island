package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.CanHunt;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.EatPlants;

public class Mouse extends Animal implements EatPlants, CanHunt {
    public Mouse() {
        setName("Мыш");
        setIcon("\uD83D\uDC01");
        setMaxWeight(0.05);
        setWeight(getMaxWeight() / 2);
        setMaxAmount(500);
        setMaxSpeed(1);
        setMaxFood(0.01);
        setSatiety(getMaxFood()/2);
    }
}

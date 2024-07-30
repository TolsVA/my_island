package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;

public class Horse extends Organism {
    public Horse() {
        setName("Лошадь");
        setIcon("\uD83D\uDC0E");
        setMaxWeight(400);
        setMaxAmount(20);
        setMaxSpeed(4);
        setMaxFood(60);
    }
}

//Buffalo  Буйвол
//Bear  Медведь
//Horse  Лошадь
//Deer  Олень

//Boar  Кабан
//Sheep  Овца
//Goat  Коза
//Wolf  Волк

//Boa  Удав
//Fox  Лиса
//Eagle  Орел
//Rabbit  Кролик

//Duck  Утка
//Mouse  Мышь
//Caterpillar  Гусеница
//Plant Растение

//entity factory   сущность фабрика
// animal factory фабрика животных

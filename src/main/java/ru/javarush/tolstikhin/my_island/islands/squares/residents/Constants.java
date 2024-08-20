package ru.javarush.tolstikhin.my_island.islands.squares.residents;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores.*;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.predators.*;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.plants.Plant;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Constants {
    public static final Map<Class<? extends Animal>, Map<Class<? extends Organism>, Integer>> ANIMALS_MAP = new HashMap<>();
    public static final Map<Class<? extends Organism>, Integer> MAP_ORGANISM_CLASS_COUNT_MAX = new LinkedHashMap<>();
    static {
        Map<Class<? extends Organism>, Integer> mapEatPlant = new HashMap<>();
        mapEatPlant.put(Plant.class, 100);
        ANIMALS_MAP.put(Horse.class, mapEatPlant);       // Лошадь - траву
        ANIMALS_MAP.put(Deer.class, mapEatPlant);        // Олень - траву
        ANIMALS_MAP.put(Rabbit.class, mapEatPlant);      // Кролик - траву
        ANIMALS_MAP.put(Goat.class, mapEatPlant);        // Коза - траву
        ANIMALS_MAP.put(Sheep.class, mapEatPlant);       // Овца - траву
        ANIMALS_MAP.put(Buffalo.class, mapEatPlant);     // Буйвол - траву
        ANIMALS_MAP.put(Caterpillar.class, mapEatPlant); // Гусеница - траву

        Map<Class<? extends Organism>, Integer> mapEatMouse = new HashMap<>();
        mapEatMouse.put(Caterpillar.class, 90);   // Мышь - гусеницу
        mapEatMouse.put(Plant.class, 100);        // Мышь - траву
        ANIMALS_MAP.put(Mouse.class, mapEatMouse);

        Map<Class<? extends Organism>, Integer> mapEatBoar = new HashMap<>();
        mapEatBoar.put(Mouse.class, 50);         // Кабан - мыш
        mapEatBoar.put(Caterpillar.class, 90);   // Кабан - гусеницу
        mapEatBoar.put(Plant.class, 100);        // Кабан - траву
        ANIMALS_MAP.put(Boar.class, mapEatBoar);

        Map<Class<? extends Organism>, Integer> mapEatDuck = new HashMap<>();
        mapEatDuck.put(Caterpillar.class, 90);   // Утка - гусеницу
        mapEatDuck.put(Plant.class, 100);        // Утка - траву
        ANIMALS_MAP.put(Duck.class,mapEatDuck);

        Map<Class<? extends Organism>, Integer> mapEatWolf = new HashMap<>();
        mapEatWolf.put(Buffalo.class, 10);       // Волк - буйвола
        mapEatWolf.put(Horse.class, 10);         // Волк - лошадь
        mapEatWolf.put(Boar.class, 15);          // Волк - кабана
        mapEatWolf.put(Deer.class, 15);          // Волк - оленя
        mapEatWolf.put(Duck.class, 40);          // Волк - утку
        mapEatWolf.put(Goat.class, 60);          // Волк - козу
        mapEatWolf.put(Rabbit.class, 60);        // Волк - кролика
        mapEatWolf.put(Sheep.class, 70);         // Волк - овцу
        mapEatWolf.put(Mouse.class, 80);         // Волк - мыш
        ANIMALS_MAP.put(Wolf.class, mapEatWolf);

        Map<Class<? extends Organism>, Integer> mapEatBoa = new HashMap<>();
        mapEatBoa.put(Duck.class, 10);           // Удав - утку
        mapEatBoa.put(Fox.class, 15);            // Удав - лису
        mapEatBoa.put(Rabbit.class, 20);         // Удав - кролика
        mapEatBoa.put(Mouse.class, 40);          // Удав - мыш
        ANIMALS_MAP.put(Boa.class, mapEatBoa);

        Map<Class<? extends Organism>, Integer> mapEatFox = new HashMap<>();
        mapEatFox.put(Duck.class, 60);           // Лиса - утку
        mapEatFox.put(Rabbit.class, 70);         // Лиса - кролика
        mapEatFox.put(Mouse.class, 90);          // Лиса - мыш
        mapEatFox.put(Caterpillar.class, 40);    // Лиса - гусеницу
        ANIMALS_MAP.put(Fox.class, mapEatFox);

        Map<Class<? extends Organism>, Integer> mapEatBear = new HashMap<>();
        mapEatBear.put(Duck.class, 10);          // Медведь - утку
        mapEatBear.put(Buffalo.class, 20);       // Медведь - буйвола
        mapEatBear.put(Horse.class, 40);         // Медведь - лошадь
        mapEatBear.put(Boar.class, 50);          // Медведь - кабана
        mapEatBear.put(Goat.class, 70);          // Медведь - козу
        mapEatBear.put(Sheep.class, 70);         // Медведь - овцу
        mapEatBear.put(Boa.class, 80);           // Медведь - удава
        mapEatBear.put(Deer.class, 80);          // Медведь - оленя
        mapEatBear.put(Rabbit.class, 80);        // Медведь - кролика
        mapEatBear.put(Mouse.class, 90);         // Медведь - мыш
        ANIMALS_MAP.put(Bear.class, mapEatBear);

        Map<Class<? extends Organism>, Integer> mapEatEagle = new HashMap<>();
        mapEatEagle.put(Fox.class, 10);          // Орел - лису
        mapEatEagle.put(Duck.class, 80);         // Орел - утку
        mapEatEagle.put(Rabbit.class, 90);       // Орел - кролика
        mapEatEagle.put(Mouse.class, 90);        // Орел - мыш
        ANIMALS_MAP.put(Eagle.class, mapEatEagle);

        MAP_ORGANISM_CLASS_COUNT_MAX.put(Plant.class, 200);
        MAP_ORGANISM_CLASS_COUNT_MAX.put(Caterpillar.class, 1000);
        MAP_ORGANISM_CLASS_COUNT_MAX.put(Mouse.class, 500);
        MAP_ORGANISM_CLASS_COUNT_MAX.put(Duck.class, 200);
        MAP_ORGANISM_CLASS_COUNT_MAX.put(Rabbit.class, 150);
        MAP_ORGANISM_CLASS_COUNT_MAX.put(Goat.class, 140);
        MAP_ORGANISM_CLASS_COUNT_MAX.put(Sheep.class, 140);
        MAP_ORGANISM_CLASS_COUNT_MAX.put(Wolf.class, 30);
        MAP_ORGANISM_CLASS_COUNT_MAX.put(Fox.class, 30);
        MAP_ORGANISM_CLASS_COUNT_MAX.put(Boa.class, 30);
        MAP_ORGANISM_CLASS_COUNT_MAX.put(Boar.class, 50);
        MAP_ORGANISM_CLASS_COUNT_MAX.put(Horse.class, 20);
        MAP_ORGANISM_CLASS_COUNT_MAX.put(Deer.class, 20);
        MAP_ORGANISM_CLASS_COUNT_MAX.put(Eagle.class, 20);
        MAP_ORGANISM_CLASS_COUNT_MAX.put(Buffalo.class, 10);
        MAP_ORGANISM_CLASS_COUNT_MAX.put(Bear.class, 5);
    }
}

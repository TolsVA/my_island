package ru.javarush.tolstikhin.my_island.app;

import ru.javarush.tolstikhin.my_island.Model;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores.*;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.predators.*;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.plants.Plant;
import ru.javarush.tolstikhin.my_island.view.windows.InitWindow;
import ru.javarush.tolstikhin.my_island.view.windows.MainApplication;

import java.util.HashMap;
import java.util.Map;

public class App {
    private static App instance;

    private App() {
        Viewable mainApplication = new MainApplication();
        InitWindow.model = new Model(FillMapOrganismCount());;
        mainApplication.run();
    }

    private Map<Class<? extends Organism>, Integer> FillMapOrganismCount() {
        Map<Class<? extends Organism>, Integer> mapOrganismCount = new HashMap<>();
        mapOrganismCount.put(Buffalo.class, 10);
        mapOrganismCount.put(Bear.class, 5);
        mapOrganismCount.put(Horse.class, 20);
        mapOrganismCount.put(Deer.class, 20);
        mapOrganismCount.put(Boar.class, 50);
        mapOrganismCount.put(Sheep.class, 140);
        mapOrganismCount.put(Goat.class, 140);
        mapOrganismCount.put(Wolf.class, 30);
        mapOrganismCount.put(Boa.class, 30);
        mapOrganismCount.put(Fox.class, 30);
        mapOrganismCount.put(Eagle.class, 20);
        mapOrganismCount.put(Rabbit.class, 150);
        mapOrganismCount.put(Duck.class, 200);
        mapOrganismCount.put(Mouse.class, 500);
        mapOrganismCount.put(Caterpillar.class, 1000);
        mapOrganismCount.put(Plant.class, 200);
        return mapOrganismCount;
    }

    public static void run() {
        if (instance == null) {
            instance = new App();
        }
    }
}

package ru.javarush.tolstikhin.my_island.app;

import ru.javarush.tolstikhin.my_island.Model;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores.*;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.predators.*;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.plants.Plant;
import ru.javarush.tolstikhin.my_island.view.windows.InitWindow;
import ru.javarush.tolstikhin.my_island.view.windows.MainApplication;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class App {
    private static App instance;

    private App() {
        Viewable mainApplication = new MainApplication();
        InitWindow.model = new Model(FillListOrganism(), FillMapOrganismCount());
        mainApplication.run();
    }

    private List<Class<? extends Organism>> FillListOrganism() {
        return new ArrayList<>(
                List.of(
                        Buffalo.class, Bear.class, Horse.class, Deer.class,
                        Boar.class, Sheep.class, Goat.class, Wolf.class,
                        Boa.class, Fox.class, Eagle.class, Rabbit.class,
                        Duck.class, Mouse.class, Caterpillar.class, Plant.class
                )
        );
    }

    private Map<Class<? extends Organism>, Integer> FillMapOrganismCount() {
        Map<Class<? extends Organism>, Integer> mapOrganismClassCount = new LinkedHashMap<>();
        mapOrganismClassCount.put(Buffalo.class, 10);
        mapOrganismClassCount.put(Bear.class, 5);
        mapOrganismClassCount.put(Horse.class, 20);
        mapOrganismClassCount.put(Deer.class, 20);
        mapOrganismClassCount.put(Boar.class, 50);
        mapOrganismClassCount.put(Sheep.class, 140);
        mapOrganismClassCount.put(Goat.class, 140);
        mapOrganismClassCount.put(Wolf.class, 30);
        mapOrganismClassCount.put(Boa.class, 30);
        mapOrganismClassCount.put(Fox.class, 30);
        mapOrganismClassCount.put(Eagle.class, 20);
        mapOrganismClassCount.put(Rabbit.class, 150);
        mapOrganismClassCount.put(Duck.class, 200);
        mapOrganismClassCount.put(Mouse.class, 500);
        mapOrganismClassCount.put(Caterpillar.class, 1000);
        mapOrganismClassCount.put(Plant.class, 200);
        return mapOrganismClassCount;
    }

    public static void run() {
        if (instance == null) {
            instance = new App();
        }
    }
}

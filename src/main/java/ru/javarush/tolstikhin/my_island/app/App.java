package ru.javarush.tolstikhin.my_island.app;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;
import ru.javarush.tolstikhin.my_island.models.Model;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores.*;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.predators.*;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.plants.Plant;
import ru.javarush.tolstikhin.my_island.view.windows.InitWindow;
import ru.javarush.tolstikhin.my_island.view.windows.MainWindow;

import java.util.*;

public class App {
    private static App instance;

    private App() {
        Viewable mainApplication = new MainWindow();
        InitWindow.model = new Model();
        mainApplication.run();
    }


    public static void run() {
        if (instance == null) {
            instance = new App();
        }
    }
}
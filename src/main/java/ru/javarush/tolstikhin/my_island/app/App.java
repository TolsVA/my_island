package ru.javarush.tolstikhin.my_island.app;

import ru.javarush.tolstikhin.my_island.view.MainApplication;
import ru.javarush.tolstikhin.my_island.view.SquareShowWindow;
import ru.javarush.tolstikhin.my_island.models.Model;
import ru.javarush.tolstikhin.my_island.view.InitWindow;

public class App {
    private static App instance;
    private static String[] args;
    private App() {
        MainApplication mainApplication = new MainApplication();
        Model model = new Model();
        InitWindow.model = model;
        SquareShowWindow.model = model;
        MainApplication.run(args);
    }


    public static void run(String[] args) {
        if (instance == null) {
            App.args = args;
            instance = new App();
        }
    }
}
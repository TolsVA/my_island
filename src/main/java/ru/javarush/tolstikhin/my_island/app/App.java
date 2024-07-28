package ru.javarush.tolstikhin.my_island.app;

import ru.javarush.tolstikhin.my_island.Model;
import ru.javarush.tolstikhin.my_island.Presentable;
import ru.javarush.tolstikhin.my_island.islands.Island;
import ru.javarush.tolstikhin.my_island.view.windows.InitWindow;
import ru.javarush.tolstikhin.my_island.view.windows.MainApplication;
public class App {
    private static App instance;

    private App() {
        Viewable view = new MainApplication();
        Presentable model = new Model();

        view.run();
    }

    public static void run() {
        if (instance == null) {
            instance = new App();
        }
    }
}

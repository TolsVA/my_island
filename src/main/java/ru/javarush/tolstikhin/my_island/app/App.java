package ru.javarush.tolstikhin.my_island.app;

import ru.javarush.tolstikhin.my_island.islands.Island;
import ru.javarush.tolstikhin.my_island.view.windows.MainApplication;
public class App {
    private static App instance;

    private App() {
        Island island = new Island();
        new MainApplication().run(island);
    }

    public static void run() {
        if (instance == null) {
            instance = new App();
        }
    }
}

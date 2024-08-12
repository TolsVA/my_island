package ru.javarush.tolstikhin.my_island.models;

import javafx.scene.Scene;
import ru.javarush.tolstikhin.my_island.controllers.InitController;
import ru.javarush.tolstikhin.my_island.islands.Island;

public interface Presentable {
    Island createIsland(int x, int y, String name, Scene scene, InitController controller);
    void start();
    void stop();
}

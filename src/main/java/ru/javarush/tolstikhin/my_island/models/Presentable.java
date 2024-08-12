package ru.javarush.tolstikhin.my_island.models;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import ru.javarush.tolstikhin.my_island.controllers.InitController;

public interface Presentable {
    GridPane createIsland(int x, int y, String name, Scene scene, InitController controller);
    void start();
    void stop();
}

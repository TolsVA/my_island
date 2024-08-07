package ru.javarush.tolstikhin.my_island.models;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

public interface Presentable {
    GridPane createIsland(int x, int y, String name, Scene scene);
    void start();
    void stop();
}

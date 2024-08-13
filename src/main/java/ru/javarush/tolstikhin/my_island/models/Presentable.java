package ru.javarush.tolstikhin.my_island.models;

import javafx.scene.Scene;
import ru.javarush.tolstikhin.my_island.controllers.InitController;
import ru.javarush.tolstikhin.my_island.view.AddsElements;
import ru.javarush.tolstikhin.my_island.view.FillsListOrganisms;

public interface Presentable {
    void createIsland(int x, int y, AddsElements addsElements, Scene scene, InitController controller, FillsListOrganisms fillsListOrganisms);
    void start();
    void stop();
}

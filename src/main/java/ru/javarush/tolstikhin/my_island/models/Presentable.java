package ru.javarush.tolstikhin.my_island.models;

import javafx.scene.Scene;
import ru.javarush.tolstikhin.my_island.controllers.InitController;
import ru.javarush.tolstikhin.my_island.islands.Island;
import ru.javarush.tolstikhin.my_island.view.AddsElements;
import ru.javarush.tolstikhin.my_island.view.FillsListOrganisms;

public interface Presentable {
    void createIsland(Island island, int x, int y, AddsElements addsElements, Scene scene, FillsListOrganisms fillsListOrganism);
    void start();
    void stop();
}

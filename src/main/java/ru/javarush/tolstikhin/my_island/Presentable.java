package ru.javarush.tolstikhin.my_island;

import javafx.scene.Scene;
import ru.javarush.tolstikhin.my_island.islands.Island;

public interface Presentable {

    Island createIsland(int x, int y, String name, Scene scene);
}

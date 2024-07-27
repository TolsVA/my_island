package ru.javarush.tolstikhin.my_island;

import ru.javarush.tolstikhin.my_island.islands.Island;
import ru.javarush.tolstikhin.my_island.view.windows.MainApplication;

public class Main {
    public static void main(String[] args) {
        new MainApplication().run(new Island());
    }
}

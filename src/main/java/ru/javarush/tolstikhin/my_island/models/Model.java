package ru.javarush.tolstikhin.my_island.models;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import ru.javarush.tolstikhin.my_island.threads.*;
import ru.javarush.tolstikhin.my_island.view.AddsElements;
import ru.javarush.tolstikhin.my_island.view.FillsListOrganisms;
import ru.javarush.tolstikhin.my_island.islands.Island;
import ru.javarush.tolstikhin.my_island.islands.squares.Square;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.Constants;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;


import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class Model implements Presentable {
    private Island island;
    private ExecutorService executorService;

    @Override
    public void createIsland(
            Island island,
            int x,
            int y,
            AddsElements addsElements,
            Scene scene,
            FillsListOrganisms fillsListOrganisms
    ) {
        this.island = island;
        executorService = Executors.newFixedThreadPool(4);
        ScrollBar scrollBar = (ScrollBar) scene.lookup("#scrColor");
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                Square squareVBox = new Square(i, j, 50);
                squareVBox.setScrollBar(scrollBar);
                squareVBox.setPadding(new Insets(0));
                addsElements.addSquare(squareVBox, i, j);
                executorService.execute(() -> gridPaneFill(squareVBox, fillsListOrganisms));
            }
        }
        executorService.shutdown();
        System.out.println("Всё");
    }

    private void gridPaneFill(Square squareVBox, FillsListOrganisms fillsListOrganisms) {
        Map<Class<? extends Organism>, List<Organism>> organismList = squareVBox.getOrganismList();
        int count;
        for (Map.Entry<Class<? extends Organism>, Integer> entry : Constants.MAP_ORGANISM_CLASS_COUNT_MAX.entrySet()) {
            Class<? extends Organism> aClass = entry.getKey();
            int maxCount = Constants.MAP_ORGANISM_CLASS_COUNT_MAX.get(aClass) + 1;
            count = ThreadLocalRandom.current().nextInt(1, maxCount);
            List<Organism> listOrganism = new ArrayList<>();
            try {
                fillListOrganism(listOrganism, aClass, count);
            } catch (RuntimeException e) {
                fillListOrganism(listOrganism, aClass, count);
            }
            organismList.put(aClass, listOrganism);
            fillsListOrganisms.fillsList(aClass);
        }
    }

    @Override
    public void start() {
        executorService = Executors.newFixedThreadPool(20);
        new Thread(() -> {
            Square[][] squaresTwo = island.getSquares();
            for (Square[] squares : squaresTwo) {
                for (Square square : squares) {
                    executorService.execute(new ThreadStartIsland(executorService, island, square));
                }
            }
        }).start();
    }

    @Override
    public void stop() {
        executorService.shutdownNow();
    }

    private void fillListOrganism(List<Organism> listOrganism, Class<? extends Organism> aClass, int count) {
        for (int o = 0; o < count; o++) {
            Organism organism;
            try {
                organism = aClass.getDeclaredConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
            if (organism instanceof Animal animal) {
                Map<Class<? extends Organism>, Integer> classIntegerMap = Constants.ANIMALS_MAP.get(aClass);
                Map<Class<? extends Organism>, Integer> food = animal.getFood();
                food.putAll(classIntegerMap);
            }
            listOrganism.add(organism);
        }
    }
}

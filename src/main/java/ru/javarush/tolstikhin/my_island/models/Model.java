package ru.javarush.tolstikhin.my_island.models;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import ru.javarush.tolstikhin.my_island.view.AddsElements;
import ru.javarush.tolstikhin.my_island.view.FillsListOrganisms;
import ru.javarush.tolstikhin.my_island.view.SquareShowWindow;
import ru.javarush.tolstikhin.my_island.controllers.InitController;
import ru.javarush.tolstikhin.my_island.islands.Island;
import ru.javarush.tolstikhin.my_island.islands.squares.Square;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.Constants;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;
import ru.javarush.tolstikhin.my_island.threads.MyCallbackClass;
import ru.javarush.tolstikhin.my_island.threads.MyThread;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class Model implements Presentable {
    private Island island;
    private final Map<Class<? extends Animal>, Map<Class<? extends Organism>, Integer>> classMapMapEat = Constants.animalsMap;
    private final Map<Class<? extends Organism>, Integer> mapOrganismClassCount = Constants.mapOrganismClassCountMax;
    private ExecutorService executorService;

    @Override
    public void createIsland(int x, int y, AddsElements addsElements, Scene scene, InitController controller, FillsListOrganisms fillsListOrganisms) {
//        island = new Island(x, y, nameIsland, scene);
        executorService = Executors.newFixedThreadPool(4);

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                Square squareVBox = new Square(j, i, 50);
                ScrollBar scrollBar = (ScrollBar) scene.lookup("#scrColor");
                squareVBox.setScrollBar(scrollBar);
                squareVBox.setPadding(new Insets(0));
                addsElements.addSquare(squareVBox, i, j);
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        gridPaneFill(squareVBox, fillsListOrganisms);
                    }
                });
            }
        }

//
////        executorService.execute(() -> island.fullForm());
        executorService.shutdown();
//        return island;
    }

    private void gridPaneFill(Square squareVBox, FillsListOrganisms fillsListOrganisms) {
        Map<Class<? extends Organism>, List<Organism>> organismList = squareVBox.getOrganismList();
        int count;
        for (Map.Entry<Class<? extends Organism>, Integer> entry : mapOrganismClassCount.entrySet()) {
            Class<? extends Organism> aClass = entry.getKey();
            count = ThreadLocalRandom.current().nextInt(1, mapOrganismClassCount.get(aClass) + 1);
            List<Organism> listOrganism = new ArrayList<>();
            fillListOrganism(listOrganism, aClass, count);
            organismList.put(aClass, listOrganism);
            fillsListOrganisms.fillsList(aClass, listOrganism);
        }
    }

    @Override
    public void start() {
        executorService = Executors.newFixedThreadPool(8);
        MyCallbackClass myCallingBack = new MyCallbackClass(executorService, island);

        Thread thread = new Thread(new MyThread(myCallingBack) {
            @Override
            public void run() {
                Square[][] squares = island.getSquares();
                for (int x = 0; x < squares.length; x++) {
                    for (int y = 0; y < squares[x].length; y++) {
                        Map<Class<? extends Organism>, List<Organism>> squareClassListOrganism = squares[x][y].getOrganismList();
                        for (List<Organism> organisms : squareClassListOrganism.values()) {
                            for (int i = 0; i < organisms.size(); i++) {
                                myCallingBack.callingBack(squareClassListOrganism, x, y, organisms.get(i), organisms);
                            }
                        }
                    }
                }
            }
        });
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            thread.interrupt();
        }

//        executorService.execute(() -> island.fullForm());
//        executorService.execute(() -> Platform.runLater(() -> island.fullForm()));

        executorService.shutdown();

//        island.fullForm();
    }

    @Override
    public void stop() {
        new SquareShowWindow().start("Общая статистика", island.getOrganismFullLinkedHashMap());
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
                Map<Class<? extends Organism>, Integer> classIntegerMap = classMapMapEat.get(aClass);
                Map<Class<? extends Organism>, Integer> food = animal.getFood();
                food.putAll(classIntegerMap);
            }
            listOrganism.add(organism);
        }
    }
}

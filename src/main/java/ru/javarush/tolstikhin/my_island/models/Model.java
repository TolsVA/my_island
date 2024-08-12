package ru.javarush.tolstikhin.my_island.models;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import ru.javarush.tolstikhin.my_island.view.SquareShowWindow;
import ru.javarush.tolstikhin.my_island.controllers.InitController;
import ru.javarush.tolstikhin.my_island.islands.Island;
import ru.javarush.tolstikhin.my_island.islands.squares.Square;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.Constants;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;
import ru.javarush.tolstikhin.my_island.threads.MyCallbackClass;
import ru.javarush.tolstikhin.my_island.threads.MyThread;

import java.io.IOException;
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
    public GridPane createIsland(int x, int y, String nameIsland, Scene scene, InitController controller) {
        island = new Island(x, y, nameIsland, scene);
        executorService = Executors.newFixedThreadPool(4);

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                island.add(gridPaneFill(i, j, scene, x, y), i, j);
            }
        }

//        executorService.execute(() -> island.fullForm());
        executorService.shutdown();
        return island;
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
        try {
            new SquareShowWindow().start(new Stage(), "Общая статистика", island.getOrganismFullLinkedHashMap());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Square gridPaneFill(int x, int y, Scene scene, int c, int i) {
        int in =468/i > 50 ? 468/i : 760/c;
        Square squareVBox = new Square(x, y, c/1.62 < i ? in : 468/i);
        Map<Class<? extends Organism>, List<Organism>> organismList = squareVBox.getOrganismList();
        ScrollBar scrollBar = (ScrollBar) scene.lookup("#scrColor");
        squareVBox.setScrollBar(scrollBar);
        squareVBox.setPadding(new Insets(0));

//        executorService.execute(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });

        executorService.execute(() -> {
            int count;
            for (Map.Entry<Class<? extends Organism>, Integer> entry : mapOrganismClassCount.entrySet()) {
                Class<? extends Organism> aClass = entry.getKey();
                count = ThreadLocalRandom.current().nextInt(1, mapOrganismClassCount.get(aClass) + 1);
                List<Organism> listOrganism = new ArrayList<>();
                fillListOrganism(listOrganism, aClass, count);
                organismList.put(aClass, listOrganism);
                island.countPositions((a, b) -> a + b, aClass, listOrganism.size());
            }
        });
        return squareVBox;
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

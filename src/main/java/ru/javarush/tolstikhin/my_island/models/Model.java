package ru.javarush.tolstikhin.my_island.models;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import ru.javarush.tolstikhin.my_island.islands.Island;
import ru.javarush.tolstikhin.my_island.islands.squares.Square;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.Constants;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;
import ru.javarush.tolstikhin.my_island.threads.MyCallingBackClass;
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
    public GridPane createIsland(int x, int y, String nameIsland, Scene scene) {
        island = new Island(x, y, nameIsland);
        executorService = Executors.newFixedThreadPool(4);

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                island.add(gridPaneFill(j, i, scene), i, j);
            }
        }

        executorService.execute(() -> {
            int index = 0;
            for (Integer value : island.getOrganismFullLinkedHashMap().values()) {
                Text text = (Text) scene.lookup("#f" + index);
                text.setText(String.valueOf(value));
                index++;
            }
        });

        executorService.shutdown();

        return island;
    }

    @Override
    public void start() {
        executorService = Executors.newFixedThreadPool(4);
        MyCallingBackClass myCallingBack = new MyCallingBackClass(executorService);

        Thread thread = new Thread(new MyThread(myCallingBack) {
            @Override
            public void run() {
                Square[][] squares = island.getSquares();
                for (int x = 0; x < squares.length; x++) {
                    for (int y = 0; y < squares[x].length; y++) {
                        Map<Class<? extends Organism>, List<Organism>> organismList = squares[x][y].getOrganismList();
                        if (!organismList.isEmpty()) {
                            myCallingBack.callingBack(organismList, x, y);
                        }
                    }
                }
            }
        });
        thread.start();

//        for (int i = 0; i < 1000; i++) {
//            System.out.println("iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
//        }

    }

    @Override
    public void stop() {
        executorService.shutdownNow();
    }

    private Square gridPaneFill(int x, int y, Scene scene) {

        Square squareVBox = new Square(x, y);
        Map<Class<? extends Organism>, List<Organism>> organismList = squareVBox.getOrganismList();

        ScrollBar scrollBar = (ScrollBar) scene.lookup("#scrColor");
        squareVBox.setScrollBar(scrollBar);
        squareVBox.setPadding(new Insets(0));

        executorService.execute(() -> {
            int count;
            for (Map.Entry<Class<? extends Organism>, Integer> entry : mapOrganismClassCount.entrySet()) {
                Class<? extends Organism> aClass = entry.getKey();
                count = ThreadLocalRandom.current().nextInt(1, mapOrganismClassCount.get(aClass) + 1);
                List<Organism> listOrganism = new ArrayList<>();
                fillListOrganism(listOrganism, aClass, count);
                organismList.put(aClass, listOrganism);
                var islandOrganismMap = island.getOrganismFullLinkedHashMap();
                if (island.getOrganismFullLinkedHashMap().containsKey(aClass)) {
                    islandOrganismMap.put(aClass, islandOrganismMap.get(aClass) + listOrganism.size());
                } else {
                    islandOrganismMap.put(aClass, listOrganism.size());
                }
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

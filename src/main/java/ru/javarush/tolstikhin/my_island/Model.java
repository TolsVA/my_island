package ru.javarush.tolstikhin.my_island;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ru.javarush.tolstikhin.my_island.islands.Island;
import ru.javarush.tolstikhin.my_island.islands.squares.Square;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.predators.Fox;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class Model implements Presentable {
    private Island island;
    private final List<Class<? extends Organism>> listOrganismClass;
    private final Map<Class<? extends Organism>, Integer> mapOrganismClassCount;

    public Model(
            List<Class<? extends Organism>> listOrganismClass,
            Map<Class<? extends Organism>, Integer> mapOrganismClassCount
    ) {
        this.listOrganismClass = listOrganismClass;
        this.mapOrganismClassCount = mapOrganismClassCount;
    }

    @Override
    public GridPane createIsland(int x, int y, String nameIsland, Scene scene) {
        island = new Island(x, y, nameIsland);
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                island.add(gridPaneFill(j, i, scene, executorService), i, j);
            }
        }

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                int index = 0;
                for (Integer value : island.getOrganismFullLinkedHashMap().values()) {
                    Text text = (Text) scene.lookup("#f" + index);
                    text.setText(String.valueOf(value));
                    index++;
                }
            }
        });

        executorService.shutdown();

        return island;
    }

    @Override
    public void ggggg() {
        List<Organism> remove = island.getSquares(0, 0).getOrganismList().remove(Fox.class);
        System.out.println(remove.size());
        remove.getFirst();
        System.out.println(remove.size());
    }

    private Square gridPaneFill(int x, int y, Scene scene, ExecutorService executorService) {

        Square squareVBox = new Square(x, y);
        Map<Class<? extends Organism>, List<Organism>> organismList = squareVBox.getOrganismList();

        ScrollBar scrollBar = (ScrollBar) scene.lookup("#scrColor");
        squareVBox.setScrollBar(scrollBar);
        squareVBox.setPadding(new Insets(0));

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                int count;
                for (Class<? extends Organism> organismClass : listOrganismClass) {
                    count = ThreadLocalRandom.current().nextInt(1, mapOrganismClassCount.get(organismClass) + 1);
                    List<Organism> listOrganism = new ArrayList<>();
                    for (int o = 0; o < count; o++) {
                        try {
                            listOrganism.add(organismClass.getDeclaredConstructor().newInstance());
                        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                                 NoSuchMethodException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    organismList.put(organismClass, listOrganism);
                    var islandOrganismMap = island.getOrganismFullLinkedHashMap();
                    if (island.getOrganismFullLinkedHashMap().containsKey(organismClass)) {
                        islandOrganismMap.put(organismClass, islandOrganismMap.get(organismClass) + listOrganism.size());
                    } else {
                        islandOrganismMap.put(organismClass, listOrganism.size());
                    }
                }
            }
        });
        return squareVBox;
    }
}

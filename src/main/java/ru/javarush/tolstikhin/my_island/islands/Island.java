package ru.javarush.tolstikhin.my_island.islands;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import ru.javarush.tolstikhin.my_island.islands.squares.Square;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;

import java.util.LinkedHashMap;
import java.util.Map;

public class Island  extends GridPane{
    private final String name;
    private final Scene scene;
    private final Square[][] squares;
    private Map<Class<? extends Organism>, Integer> organismFullLinkedHashMap = new LinkedHashMap<>();

//    private  static Island instance;

    public Island(double x, double y, String name, Scene scene) {
        super(x, y);
        this.name = name;
        this.scene = scene;
        this.squares = new Square[(int) x][(int) y];
    }


//    public static Island getInstance(double x, double y, String name, Scene scene){
//        if (instance == null) {
//            instance= new Island(x, y, name, scene);
//        }
//        return instance;
//    }

    @Override
    public void add(Node node, int x, int y) {
        super.add(node, x, y);
        super.setHgap(1);
        super.setVgap(1);
        squares[x][y] = (Square) node;
    }

    public Square getSquares(int x, int y) {
        return squares[x][y];
    }

    public Square[][] getSquares() {
        return squares;
    }


    public String getName() {
        return name;
    }

    public Map<Class<? extends Organism>, Integer> getOrganismFullLinkedHashMap() {
        return organismFullLinkedHashMap;
    }


    public synchronized void fullForm(){
        for (Map.Entry<Class<? extends Organism>, Integer> classIntegerEntry : organismFullLinkedHashMap.entrySet()) {
            Text text = (Text) scene.lookup("#" + classIntegerEntry.getKey().getSimpleName().toLowerCase());
            text.setText(String.valueOf(classIntegerEntry.getValue().intValue()));
        }

//        int index = 0;
//        for (Integer value : organismFullLinkedHashMap.values()) {
//            Text text = (Text) scene.lookup("#f" + index);
//            text.setText(String.valueOf(value));
//            index++;
//        }
    }

    public void fullForm(Class<? extends Organism> aClass){
        Text text = (Text) scene.lookup("#" + aClass.getSimpleName().toLowerCase());
        text.setText(String.valueOf(organismFullLinkedHashMap.get(aClass).intValue()));
    }

//    @Override
    public void countPositions(MyInterface method, Class<? extends Organism> aClass, int count) {
        if (!organismFullLinkedHashMap.containsKey(aClass)) organismFullLinkedHashMap.put(aClass, count);
        else organismFullLinkedHashMap.put(aClass, method.apply(organismFullLinkedHashMap.get(aClass), count));
    }
}

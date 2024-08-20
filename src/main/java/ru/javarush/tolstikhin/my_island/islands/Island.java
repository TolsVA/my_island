package ru.javarush.tolstikhin.my_island.islands;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import ru.javarush.tolstikhin.my_island.islands.squares.Square;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Island  extends GridPane{
    private final int sizeX;
    private final int sizeY;
    private final Square[][] squares;
    private final Map<Class<? extends Organism>, List<Organism>> organismFullLinkedHashMap = new LinkedHashMap<>();

    public Island(double x, double y) {
        super(x, y);
        sizeX = (int) x;
        sizeY = (int) y;
        this.squares = new Square[sizeX][sizeY];
    }

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

    public Map<Class<? extends Organism>, List<Organism>> getOrganismFullLinkedHashMap() {
        return organismFullLinkedHashMap;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    //    @Override
    public void addClassListOrganisms(Class<? extends Organism> aClass) {
        if (!organismFullLinkedHashMap.containsKey(aClass)) {
            Field listOrganismOfOneType;
            List<Organism> organisms;
            try {
                listOrganismOfOneType = aClass.getDeclaredField("LIST_ORGANISM_OF_ONE_TYPE");
                organisms = (List<Organism>) listOrganismOfOneType.get(null);

            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            organismFullLinkedHashMap.put(aClass, organisms);
        }
    }
}

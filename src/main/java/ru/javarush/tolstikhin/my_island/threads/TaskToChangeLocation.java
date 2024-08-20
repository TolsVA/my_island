package ru.javarush.tolstikhin.my_island.threads;

import ru.javarush.tolstikhin.my_island.islands.Island;
import ru.javarush.tolstikhin.my_island.islands.squares.Square;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class TaskToChangeLocation extends Task {
    private final Island island;
    private Square square;
    private final int maxSizeX;                                                    // максимальное значение по X
    private final int maxSizeY;

    public TaskToChangeLocation(
            Square square,
            Map<Class<? extends Organism>, List<Organism>> squareClassListOrganism,
            Animal animal,
            List<Organism> organisms,
            Island island
    ) {
        super(squareClassListOrganism, animal, organisms);
        this.island = island;
        this.square = square;
        maxSizeX = this.island.getSizeX() - 1;
        maxSizeY = this.island.getSizeY() - 1;
    }

    @Override
    public void run() {
        if (animal.isFlag()) {
            int speed = ThreadLocalRandom.current().nextInt(0, animal.getMaxSpeed() + 1); // количество перемещений
            while (speed > 0) {
                List<List<Integer>> directs = getDirects();
                if (!directs.isEmpty()) {
                    int indexCoordinate = ThreadLocalRandom.current().nextInt(0, directs.size());
                    int newX = directs.get(indexCoordinate).get(0);
                    int newY = directs.get(indexCoordinate).get(1);
                    Square newSquare = island.getSquares(newX, newY);
                    Map<Class<? extends Organism>, List<Organism>> newOrganismList = newSquare.getOrganismList();
                    List<Organism> newOrganisms = newOrganismList.get(animal.getClass());
                    if(organisms.remove(animal)) {
                        newOrganisms.add(animal);
                    }
                    System.out.println(
                            animal.getIcon() + " переместился с квадрата [" + square.getX() + ", " + square.getY() +
                                    "] на квадрат [" + newX + ", " + newY + "]"
                    );
                    square = newSquare;
                    speed--;

                } else break;
            }
        }
        animal.setFlag(false);
    }

    private List<List<Integer>> getDirects() {         // максимальное значение по Y
        List<List<Integer>> directs = new ArrayList<>();
        if (square.getX() > 0) directs.add(new ArrayList<>(List.of(square.getX() - 1, square.getY())));
        if (square.getX() < maxSizeX) directs.add(new ArrayList<>(List.of(square.getX() + 1, square.getY())));
        if (square.getY() > 0) directs.add(new ArrayList<>(List.of(square.getX(), square.getY() - 1)));
        if (square.getY() < maxSizeY) directs.add(new ArrayList<>(List.of(square.getX(), square.getY() + 1)));
        return directs;
    }
}

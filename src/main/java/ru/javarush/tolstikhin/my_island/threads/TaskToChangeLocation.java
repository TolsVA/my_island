package ru.javarush.tolstikhin.my_island.threads;

import ru.javarush.tolstikhin.my_island.islands.Island;
import ru.javarush.tolstikhin.my_island.islands.squares.Square;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class TaskToChangeLocation extends Task {
    public static final Object LOOK = new Object();
    private final Island island;
    private Square square;

    public TaskToChangeLocation(
            Square square,
            Map<Class<? extends Organism>, List<Organism>> squareClassListOrganism,
            Organism organism,
            List<Organism> organisms,
            Island island
    ) {
        super(squareClassListOrganism, organism, organisms);
        this.island = island;
        this.square = square;
    }

    @Override
    public void run() {
        if (organism instanceof Animal animal) {
            int speed = ThreadLocalRandom.current().nextInt(0, animal.getMaxSpeed() + 1); // количество перемещений
            int maxSizeX = island.getSizeX() - 1;                                                        // максимальное значение по X
            int maxSizeY = island.getSizeY() - 1;                                                        // максимальное значение по Y
            while (speed > 0) {
                List<List<Integer>> directs = new ArrayList<>();
                if (square.getX() > 0) directs.add(new ArrayList<>(List.of(square.getX() - 1, square.getY())));
                if (square.getX() < maxSizeX) directs.add(new ArrayList<>(List.of(square.getX() + 1, square.getY())));
                if (square.getY() > 0) directs.add(new ArrayList<>(List.of(square.getX(), square.getY() - 1)));
                if (square.getY() < maxSizeY) directs.add(new ArrayList<>(List.of(square.getX(), square.getY() + 1)));
                int indexCoordinate = ThreadLocalRandom.current().nextInt(0, directs.size());
                int newX = directs.get(indexCoordinate).get(0);
                int newY = directs.get(indexCoordinate).get(1);

                Square newSquare = island.getSquares(newX, newY);
                Map<Class<? extends Organism>, List<Organism>> newOrganismList = newSquare.getOrganismList();
                List<Organism> newOrganisms = newOrganismList.get(animal.getClass());
                if (organisms.remove(animal)) {
                    newOrganisms.add(animal);
                    square = newSquare;
                    speed--;
                }
            }
        }
    }
}

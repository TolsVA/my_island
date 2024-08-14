package ru.javarush.tolstikhin.my_island.threads;

import ru.javarush.tolstikhin.my_island.islands.Island;
import ru.javarush.tolstikhin.my_island.islands.squares.Square;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class TaskToChangeLocation extends Task implements Runnable{
    private final int[] coordinates;
    private final int[] directions = {-1, 1};
    private final Island island;

    public TaskToChangeLocation(
            Square square,
            Map<Class<? extends Organism>, List<Organism>> squareClassListOrganism,
            Organism organism,
            List<Organism> organisms,
            Island island
    ) {
        super(squareClassListOrganism, organism, organisms);
        coordinates = new int[]{
                square.getX(),
                square.getY()
        };
        this.island = island;
    }

    @Override
    public void run() {
        if (organism instanceof Animal animal){
            int speed = ThreadLocalRandom.current().nextInt(0, animal.getMaxSpeed() + 1); // количество перемещений

            while (speed > 0) {
                int direction = ThreadLocalRandom.current().nextInt(0, directions.length);      // направление вверх вниз или в право лево
                int coordinate = ThreadLocalRandom.current().nextInt(0, coordinates.length);    // определяем направление X или Y
                int sizeX = island.getSizeX();                                                        // местоположение по X
                int sizeY = island.getSizeY();                                                        // местоположение по Y
                if (coordinate == 0 && coordinates[coordinate] + direction >= 0
                        && coordinates[coordinate] + direction <= sizeX){
                    // логика перемещения
                    speed--;
                }

                if (coordinate == 1 && coordinates[coordinate] + direction >= 0
                        && coordinates[coordinate] + direction <= sizeY){
                    // логика перемещения
                    speed--;
                }
            }
        }
    }
}

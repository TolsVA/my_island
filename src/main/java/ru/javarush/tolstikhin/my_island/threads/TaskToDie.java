package ru.javarush.tolstikhin.my_island.threads;

import ru.javarush.tolstikhin.my_island.islands.Island;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.Animal;

import java.util.List;
import java.util.Map;

public class TaskToDie extends Task{
    private  final Island island;

    protected TaskToDie(
            Map<Class<? extends Organism>, List<Organism>> squareClassListOrganism,
            Animal animal,
            List<Organism> organisms,
            Island island
    ) {
        super(squareClassListOrganism, animal, organisms);
        this.island = island;
    }

    @Override
    public void run() {
        animal.setWeight(-(animal.getMaxFood() > 0 ? animal.getMaxFood() / 10 : 0));
        if (animal.getWeight() <= 0) {
            organisms.remove(animal);
            island.getOrganismFullLinkedHashMap().get(animal.getClass()).remove(animal);
            System.out.print(animal.getIcon() + " - умер от голода");
        }
    }
}

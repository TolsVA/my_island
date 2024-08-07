package ru.javarush.tolstikhin.my_island.threads;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class MyCallingBackClass implements MyCallingBack {
    private ExecutorService executorService;
    public MyCallingBackClass(ExecutorService executorService) {
        this.executorService = executorService;
    }

    @Override
    public void callingBack(Map<Class<? extends Organism>, List<Organism>> classListMap, int x, int y) {
        executorService.execute(new TaskToEat(classListMap, x, y));  // задача есть
        executorService.execute(new TaskToMate(classListMap, x, y)); // задача спариваться
    }
    public ExecutorService getExecutorService(){
        return executorService;
    }
}

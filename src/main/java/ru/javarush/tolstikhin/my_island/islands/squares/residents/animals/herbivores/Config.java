package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value= ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Config {
    String name();
    String icon();
    int maxWeight(); // Вес одного животного, кг.
    int maxAmount(); // 	Максимальное количество животных этого вида на одной клетке.
    int maxSpeed();  // Скорость перемещения, не более чем, клеток за ход.
    int maxFood(); // Сколько килограммов пищи нужно животному для полного насыщения.
}

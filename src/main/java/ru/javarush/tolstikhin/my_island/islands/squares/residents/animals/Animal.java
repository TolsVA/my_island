package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;

import java.util.concurrent.ThreadLocalRandom;

public class Animal extends Organism {
//    private double maxWeight; // Вес одного животного, кг.
//    private int maxAmount; // 	Максимальное количество животных этого вида на одной клетке.

    private int maxSpeed;  // Скорость перемещения, не более чем, клеток за ход.
    private double maxFood; // Сколько килограммов пищи нужно животному для полного насыщения.
    private double satiety; // сытность
    private final String[] genders = {"masculine", "feminine"};
    private final String gender = randomGender();  // пол

    public int getMaxSpeed() {
        return maxSpeed;
    }

    private String randomGender(){
        return genders[ThreadLocalRandom.current().nextInt(genders.length)];
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getMaxFood() {
        return maxFood;
    }

    public void setMaxFood(double maxFood) {
        this.maxFood = maxFood;
    }

    public double getSatiety() {
        return satiety;
    }

    public void setSatiety(double satiety) {
        if (this.satiety == 0) {
            this.satiety = satiety;
        } else {
            this.satiety = this.satiety + satiety;
            if (this.satiety > maxFood){
                this.satiety = maxFood;
            }
        }
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Animal{" + super.toString() +
                "maxSpeed=" + maxSpeed +
                ", maxFood=" + maxFood +
                '}';
    }
}

package ru.javarush.tolstikhin.my_island.islands.squares.residents.animals;

import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal extends Organism {
    private final Map<Class<? extends Organism>, Integer> food = new HashMap<>();
    private int maxSpeed;  // Скорость перемещения, не более чем, клеток за ход.
    private double maxFood; // Сколько килограммов пищи нужно животному для полного насыщения.
    private double satiety; // сытность
    private final String[] genders = {"male", "female"};
    private final String gender = randomGender();  // пол

    public Map<Class<? extends Organism>, Integer> getFood(){
        return food;
    }

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
            setWeight(satiety);
            if (this.satiety > maxFood){
                this.satiety = maxFood;
            }
        }
    }

    public String getGender() {
        return gender;
    }

//    @Override
//    public String toString() {
//        return super.toString() +
//                ", maxSpeed = '" + maxSpeed + '\'' +
//                ", maxFood = '" + maxFood + '\'';
//    }


    @Override
    public String toString() {
        return super.toString() +
                ", maxSpeed = '" + maxSpeed + '\'' +
                ", maxFood = '" + maxFood + '\'' +
                ", satiety = '" + satiety + '\'' +
                ", gender = '" + gender + '\'';
    }

//    public void eat(double eat) {
//        satiety = satiety + eat;
//        if (satiety > getMaxWeight()) satiety = getMaxWeight();
//    }
}

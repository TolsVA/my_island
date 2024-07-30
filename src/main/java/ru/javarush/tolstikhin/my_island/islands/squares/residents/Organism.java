package ru.javarush.tolstikhin.my_island.islands.squares.residents;

import lombok.Getter;
import lombok.Setter;

//@Setter
//@Getter
public abstract class Organism implements Cloneable{
    private String name;
    private String icon;
    private double maxWeight; // Вес одного животного, кг.
    private int maxAmount; // 	Максимальное количество животных этого вида на одной клетке.
    private int maxSpeed;  // Скорость перемещения, не более чем, клеток за ход.
    private double maxFood; // Сколько килограммов пищи нужно животному для полного насыщения.

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Organism{");
        sb.append("name='").append(name).append('\'');
        sb.append(", icon='").append(icon).append('\'');
        sb.append(", maxWeight=").append(maxWeight);
        sb.append(", maxAmount=").append(maxAmount);
        sb.append(", maxSpeed=").append(maxSpeed);
        sb.append(", maxFood=").append(maxFood);
        sb.append('}');
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(int maxAmount) {
        this.maxAmount = maxAmount;
    }

    public int getMaxSpeed() {
        return maxSpeed;
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

    @Override
    public Organism clone() {
        try {
            Organism clone = (Organism) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

package ru.javarush.tolstikhin.my_island.islands.squares.residents;

public abstract class Organism {
    private String name;
    private String icon;
    private double maxWeight;        // Максимальный вес одного животного, кг.
    private double weight;
    private int maxAmount;           // Максимальное количество животных этого вида на одной клетке.

    @Override
    public String toString() {
        return "name = '" + name + '\'' +
                ", icon = '" + icon + '\'' +
                ", maxWeight = '" + maxWeight + '\'' +
                ", weight=" + weight +
                ", maxAmount = " + maxAmount + '\'';
    }


    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (this.weight == 0) {
            this.weight = weight;
        } else {
            this.weight = this.weight + weight;
            if (this.weight > maxWeight) {
                this.weight = maxWeight;
            }
        }
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
}

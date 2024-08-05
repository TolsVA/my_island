package ru.javarush.tolstikhin.my_island.islands.squares.residents;

public abstract class Organism implements Cloneable{
    private String name;
    private String icon;
    private double maxWeight; // Вес одного животного, кг.
    private int maxAmount; // 	Максимальное количество животных этого вида на одной клетке.

    @Override
    public String toString() {
        return "Organism{" + "name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", maxWeight=" + maxWeight +
                ", maxAmount=" + maxAmount +
                '}';
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

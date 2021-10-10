package com.anish.calabashbros;

public interface Sorter<T extends Creature&Comparable<T>> {
    public void load(Matrix<T> a);

    public void sort();

    public String getPlan();
}
